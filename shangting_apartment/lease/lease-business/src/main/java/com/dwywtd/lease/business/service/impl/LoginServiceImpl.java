package com.dwywtd.lease.business.service.impl;

import com.atguigu.lease.infrastructure.JwtUtil;
import com.dwywtd.lease.business.common.RedisConstant;
import com.dwywtd.lease.business.domain.SystemUser;
import com.dwywtd.lease.business.enums.BaseStatus;
import com.dwywtd.lease.business.service.LoginService;
import com.dwywtd.lease.business.service.SystemUserService;
import com.dwywtd.lease.business.vo.CaptchaVo;
import com.dwywtd.lease.business.vo.LoginVo;
import com.dwywtd.lease.business.vo.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private final StringRedisTemplate redisTemplate;

    private final SystemUserService systemUserService;

    public LoginServiceImpl(StringRedisTemplate redisTemplate, SystemUserService systemUserService) {
        this.redisTemplate = redisTemplate;
        this.systemUserService = systemUserService;
    }

    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = RedisConstant.ADMIN_LOGIN_PREFIX + UUID.randomUUID();
        // 存入redis并设置过期时间为60s
        redisTemplate.opsForValue().set(key, verCode, RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        // 将key和base64返回给前端
        return new CaptchaVo(specCaptcha.toBase64(), key);
    }

    /**
     * 用户登录的校验逻辑分为三个主要步骤，分别是**校验验证码**，**校验用户状态**和**校验密码**，具体逻辑如下
     * <p>
     * - 前端发送`username`、`password`、`captchaKey`、`captchaCode`请求登录。
     * - 判断`captchaCode`是否为空，若为空，则直接响应`验证码为空`；若不为空进行下一步判断。
     * - 根据`captchaKey`从Redis中查询之前保存的`code`，若查询出来的`code`为空，则直接响应`验证码已过期`；若不为空进行下一步判断。
     * - 比较`captchaCode`和`code`，若不相同，则直接响应`验证码不正确`；若相同则进行下一步判断。
     * - 根据`username`查询数据库，若查询结果为空，则直接响应`账号不存在`；若不为空则进行下一步判断。
     * - 查看用户状态，判断是否被禁用，若禁用，则直接响应`账号被禁`；若未被禁用，则进行下一步判断。
     * - 比对`password`和数据库中查询的密码，若不一致，则直接响应`账号或密码错误`，若一致则进行入最后一步。
     * - 创建JWT，并响应给浏览器。
     */
    @Override
    public String login(LoginVo loginVo) {
        String captchaKey = loginVo.getCaptchaKey();
        String captchaCode = loginVo.getCaptchaCode();
        if (captchaKey == null || captchaCode == null) {
            throw new RuntimeException("验证码无效");
        }

        String redisCaptchaCode = redisTemplate.opsForValue().get(captchaKey);
        if (redisCaptchaCode == null || !redisCaptchaCode.equalsIgnoreCase(captchaCode)) {
            throw new RuntimeException("验证码错误");
        }
        redisTemplate.delete(captchaKey);

        SystemUser systemUser = systemUserService.getByUsernameWithPassword(loginVo.getUsername());

        // 判断用户是否存在
        if (systemUser == null) {
            throw new RuntimeException("账户不存在");
        }

        // 判断用户状态
        if (systemUser.getStatus() == null || systemUser.getStatus().equals(BaseStatus.DISABLE)) {
            throw new RuntimeException("账户被禁用");
        }

        // 密码校验
        if (!systemUser.getPassword().equals(loginVo.getPassword())) {
            throw new RuntimeException("账户或密码错误");
        }

        //6.创建并返回TOKEN
        return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
    }


    @Override
    public SystemUserInfoVo getLoginUserInfo(Long userId) {
        SystemUser systemUser = systemUserService.getById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}

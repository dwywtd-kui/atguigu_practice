package com.dwywtd.lease.web.controller.admin;

import com.atguigu.lease.infrastructure.LoginUserHolder;
import com.atguigu.lease.infrastructure.result.Result;
import com.atguigu.lease.infrastructure.result.ResultBuild;
import com.dwywtd.lease.business.service.LoginService;
import com.dwywtd.lease.business.vo.CaptchaVo;
import com.dwywtd.lease.business.vo.LoginVo;
import com.dwywtd.lease.business.vo.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@ResultBuild
@RequestMapping("/admin")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Operation(summary = "获取图形验证码")
    @GetMapping("/login/captcha")
    public CaptchaVo getCaptcha() {
        return loginService.getCaptcha();
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info() {
        SystemUserInfoVo userInfo = loginService.getLoginUserInfo(LoginUserHolder.getLoginUser().getUserId());
        return Result.ok(userInfo);
    }

    @Operation(summary = "登录")
    @PostMapping(value = "login", produces = "application/json;charset=utf-8")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        return Result.ok(loginService.login(loginVo));
    }

    @Operation(summary = "退出登录")
    @GetMapping("logout")
    public String logout() {
        return null;
    }
}

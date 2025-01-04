package com.dwywtd.lease.web.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwywtd.lease.business.domain.UserInfo;
import com.dwywtd.lease.business.enums.BaseStatus;
import com.dwywtd.lease.business.service.UserInfoService;
import com.atguigu.lease.infrastructure.result.ResultBuild;
import com.dwywtd.lease.web.vo.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户信息管理")
@ResultBuild
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Operation(summary = "分页查询用户信息")
    @GetMapping("page")
    public IPage<UserInfo> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo userInfoQueryVo) {
        String phone = userInfoQueryVo.getPhone();
        BaseStatus status = userInfoQueryVo.getStatus();
        return userInfoService.lambdaQuery()
                .eq(StringUtils.hasLength(phone), UserInfo::getPhone, phone)
                .eq(status != null, UserInfo::getStatus, status)
                .page(new Page<>(current, size));
    }

    @Operation(summary = "根据用户id更新账号状态")
    @PostMapping("updateStatusById")
    public void updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        userInfoService.lambdaUpdate().eq(UserInfo::getId, id).set(UserInfo::getStatus, status).update();
    }
}

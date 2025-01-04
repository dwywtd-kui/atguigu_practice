package com.dwywtd.lease.web.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dwywtd.lease.business.domain.UserInfo;
import com.dwywtd.lease.web.result.Result;
import com.dwywtd.lease.web.result.ResultBuild;
import com.dwywtd.lease.web.vo.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户信息管理")
@ResultBuild
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    @Operation(summary = "分页查询用户信息")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        return Result.ok();
    }

//    @Operation(summary = "根据用户id更新账号状态")
//    @PostMapping("updateStatusById")
//    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
//        return Result.ok();
//    }
}

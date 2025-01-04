package com.dwywtd.lease.web.controller.admin;


import com.atguigu.lease.infrastructure.result.ResultBuild;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwywtd.lease.business.domain.SystemPost;
import com.dwywtd.lease.business.domain.SystemUser;
import com.dwywtd.lease.business.enums.BaseStatus;
import com.dwywtd.lease.business.service.SystemPostService;
import com.dwywtd.lease.business.service.SystemUserService;
import com.dwywtd.lease.web.vo.SystemUserItemVo;
import com.dwywtd.lease.web.vo.SystemUserQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Tag(name = "后台用户信息管理")
@ResultBuild
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {

    private final SystemUserService systemUserService;
    private final SystemPostService systemPostService;

    public SystemUserController(SystemUserService systemUserService, SystemPostService systemPostService) {
        this.systemUserService = systemUserService;
        this.systemPostService = systemPostService;
    }

    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public IPage<SystemUserItemVo> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        Page<SystemUser> userPage = systemUserService.lambdaQuery()
                .like(StringUtils.hasLength(queryVo.getName()), SystemUser::getName, queryVo.getName())
                .eq(StringUtils.hasLength(queryVo.getPhone()), SystemUser::getPhone, queryVo.getPhone()).page(new Page<>(current, size));
        return userPage.convert(user -> {
            SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
            BeanUtils.copyProperties(user, systemUserItemVo);
            SystemPost systemPost = systemPostService.lambdaQuery().eq(SystemPost::getId, user.getPostId()).one();
            if (systemPost != null) {
                systemUserItemVo.setPostName(systemPost.getName());
            }
            return systemUserItemVo;
        });
    }

    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public SystemUserItemVo getById(@RequestParam Long id) {
        SystemUser systemUser = systemUserService.getById(id);
        if (systemUser == null) {
            return null;
        }
        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemUser, systemUserItemVo);
        SystemPost systemPost = systemPostService.lambdaQuery().eq(SystemPost::getId, systemUser.getPostId()).one();
        if (systemPost != null) {
            systemUserItemVo.setPostName(systemPost.getName());
        }
        return systemUserItemVo;
    }

    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public void saveOrUpdate(@RequestBody SystemUser systemUser) {
        systemUserService.saveOrUpdate(systemUser);
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Boolean isUsernameExists(@RequestParam String username) {
        return systemUserService.lambdaQuery()
                .eq(SystemUser::getUsername, username)
                .count() == 0;
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public void removeById(@RequestParam Long id) {
        systemUserService.removeById(id);
    }

    @Operation(summary = "根据ID修改状态")
    @PostMapping("updateStatusByUserId")
    public void updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        systemUserService.lambdaUpdate()
                .eq(SystemUser::getId, id)
                .set(SystemUser::getStatus, status)
                .update();
    }
}


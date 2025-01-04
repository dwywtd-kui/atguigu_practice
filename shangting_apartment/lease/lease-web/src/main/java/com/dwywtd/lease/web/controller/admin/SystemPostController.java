package com.dwywtd.lease.web.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dwywtd.lease.business.domain.SystemPost;
import com.dwywtd.lease.business.enums.BaseStatus;
import com.dwywtd.lease.business.service.SystemPostService;
import com.atguigu.lease.infrastructure.result.Result;
import com.atguigu.lease.infrastructure.result.ResultBuild;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResultBuild
@RestController
@Tag(name = "后台用户岗位管理")
@RequestMapping("/admin/system/post")
public class SystemPostController {

    private final SystemPostService systemPostService;

    public SystemPostController(SystemPostService systemPostService) {
        this.systemPostService = systemPostService;
    }

    @Operation(summary = "分页获取岗位信息")
    @GetMapping("page")
    private IPage<SystemPost> page(@RequestParam long current, @RequestParam long size) {
        return systemPostService.page(new Page<>(current, size));
    }


    @Operation(summary = "保存或更新岗位信息")
    @PostMapping("saveOrUpdate")
    public Result<SystemPost> saveOrUpdate(@RequestBody SystemPost systemPost) {
        systemPostService.saveOrUpdate(systemPost);
        return Result.ok(systemPost);
    }

    @Operation(summary = "根据ID删除岗位信息")
    @DeleteMapping("deleteById")
    public void deleteById(@RequestParam Long id) {
        systemPostService.removeById(id);
    }

    @Operation(summary = "根据ID查询岗位信息")
    @GetMapping("getById")
    public Result<SystemPost> getById(@RequestParam Long id) {
        return Result.ok(systemPostService.getById(id));
    }

    @Operation(summary = "查询全部岗位信息")
    @GetMapping("list")
    public Result<List<SystemPost>> list() {
        return Result.ok(systemPostService.list());
    }

    @Operation(summary = "根据岗位id修改状态")
    @PostMapping("updateStatusByPostId")
    public void updateStatusByPostId(@RequestParam Long id, @RequestParam BaseStatus status) {
        systemPostService.lambdaUpdate().eq(SystemPost::getId, id).set(SystemPost::getStatus, status).update();
    }
}

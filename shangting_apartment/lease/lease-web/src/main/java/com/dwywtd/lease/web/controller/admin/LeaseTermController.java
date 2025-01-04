package com.dwywtd.lease.web.controller.admin;

import com.dwywtd.lease.business.dto.LeaseTerm;
import com.dwywtd.lease.business.service.LeaseTermService;
import com.dwywtd.lease.web.result.ResultBuild;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "租期管理")
@ResultBuild
@RequestMapping("/admin/term")
@RestController
public class LeaseTermController {

    @Autowired
    private LeaseTermService service;

    @GetMapping("list")
    @Operation(summary = "查询全部租期列表")
    public List<LeaseTerm> listLeaseTerm() {
        return service.list();
    }

    @PostMapping("saveOrUpdate")
    @Operation(summary = "保存或更新租期信息")
    public LeaseTerm saveOrUpdate(@RequestBody LeaseTerm leaseTerm) {
        return service.saveOrUpdate(leaseTerm);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除租期")
    public void deleteLeaseTermById(@RequestParam Long id) {
        service.removeById(id);
    }
}
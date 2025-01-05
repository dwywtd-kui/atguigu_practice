package com.dwywtd.lease.web.controller.admin;

import com.atguigu.lease.infrastructure.result.ResultBuild;
import com.dwywtd.lease.business.service.FeeKeyService;
import com.dwywtd.lease.business.service.FeeValueService;
import com.dwywtd.lease.business.vo.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.dwywtd.lease.business.domain.FeeKey;
import com.dwywtd.lease.business.domain.FeeValue;

import java.util.List;

@Tag(name = "房间杂费管理")
@ResultBuild
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    private static final String CLASSIFY_NAME = "fee";

    private final FeeKeyService feeKeyService;
    private final FeeValueService feeValueService;

    public FeeController(FeeKeyService feeKeyService, FeeValueService feeValueService) {
        this.feeKeyService = feeKeyService;
        this.feeValueService = feeValueService;
    }


    @Operation(summary = "保存或更新杂费名称")
    @PostMapping("key/saveOrUpdate")
    public FeeKey saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        if (feeKey.getId() == null) {
            feeKeyService.save(feeKey);
        } else {
            feeKeyService.updateById(feeKey);
        }
        return feeKey;
    }

    @Operation(summary = "根据id删除杂费名称")
    @DeleteMapping("key/deleteById")
    public void deleteFeeKeyById(@RequestParam Long feeKeyId) {
        feeKeyService.removeById(feeKeyId);
    }

    @Operation(summary = "查询全部杂费名称和杂费值列表")
    @GetMapping("list")
    public List<FeeKeyVo> feeInfoList() {
        return feeKeyService.getFeeKeyVoList();
    }


    @Operation(summary = "保存或更新杂费值")
    @PostMapping("value/saveOrUpdate")
    public FeeValue saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        if (feeValue.getId() == null) {
            feeValueService.save(feeValue);
        } else {
            feeValueService.updateById(feeValue);
        }
        return feeValue;
    }

    @Operation(summary = "根据id删除杂费值")
    @DeleteMapping("value/deleteById")
    public void deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
    }
}

package com.dwywtd.lease.web.controller.admin;

import com.atguigu.lease.infrastructure.result.Result;
import com.atguigu.lease.infrastructure.result.ResultBuild;
import com.dwywtd.lease.business.domain.CityInfo;
import com.dwywtd.lease.business.domain.DistrictInfo;
import com.dwywtd.lease.business.domain.ProvinceInfo;
import com.dwywtd.lease.business.service.RegionInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "地区信息管理")
@ResultBuild
@RestController
@RequestMapping("/admin/region")
public class RegionInfoController {

    private final RegionInfoService regionInfoService;

    public RegionInfoController(RegionInfoService regionInfoService) {
        this.regionInfoService = regionInfoService;
    }

    @Operation(summary = "查询省份信息列表")
    @GetMapping("province/list")
    public Result<List<ProvinceInfo>> listProvince() {
        List<ProvinceInfo> provinceInfos = regionInfoService.listProvince();
        return Result.ok(provinceInfos);
    }


    @Operation(summary = "根据省份id查询城市信息列表")
    @GetMapping("city/listByProvinceId")
    public Result<List<CityInfo>> listCityInfoByProvinceId(@RequestParam Long id) {
        List<CityInfo> cityInfos = regionInfoService.listCityInfoByProvinceId(id);
        return Result.ok(cityInfos);
    }


    @GetMapping("district/listByCityId")
    @Operation(summary = "根据城市id查询区县信息")
    public Result<List<DistrictInfo>> listDistrictInfoByCityId(@RequestParam Long id) {
        return Result.ok(regionInfoService.listDistrictInfoByCityId(id));
    }


}

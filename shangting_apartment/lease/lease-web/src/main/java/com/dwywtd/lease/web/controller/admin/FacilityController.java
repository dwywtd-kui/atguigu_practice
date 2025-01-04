package com.dwywtd.lease.web.controller.admin;


import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.dto.FacilityInfo;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.web.result.ResultBuild;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "配套管理")
@ResultBuild
@RestController
@RequestMapping("/admin/facility")
public class FacilityController {

    private final DataDictService dataDictService;

    public FacilityController(DataDictService dataDictService) {
        this.dataDictService = dataDictService;
    }

    @Operation(summary = "[根据类型]查询配套信息列表")
    @GetMapping("list")
    public List<FacilityInfo> listFacility(@RequestParam(required = false) FacilityInfo.FacilityType type) {
        List<DataDict> dataDictList;
        if (type == null) {
            List<FacilityInfo.FacilityType> facilityTypes = List.of(FacilityInfo.FacilityType.values());
            List<DataDict.DataGroupEnum> dataGroupEnumList = facilityTypes.stream().map(i -> {
                return DataDict.DataGroupEnum.codeValueOf(i.getCode());
            }).collect(Collectors.toList());
            dataDictList = dataDictService.listByGroups(dataGroupEnumList);
        } else {
            dataDictList = dataDictService.listByGroup(DataDict.DataGroupEnum.codeValueOf(type.getCode()));
        }
        return dataDictList.stream().map(this::map).collect(Collectors.toList());
    }

    @Operation(summary = "新增或修改配套信息")
    @PostMapping("saveOrUpdate")
    public FacilityInfo saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        DataDict dataDict = map(facilityInfo);
        if (facilityInfo.getId() != null) {
            dataDictService.updateById(dataDict);
        } else {
            dataDictService.save(dataDict);
        }
        return map(dataDict);
    }

    @Operation(summary = "根据id删除配套信息")
    @DeleteMapping("deleteById")
    public void removeFacilityById(@RequestParam Long id) {
        dataDictService.removeById(id);
    }


    private FacilityInfo map(DataDict dataDict) {
        FacilityInfo facilityInfo = new FacilityInfo();
        BeanUtils.copyProperties(dataDict, facilityInfo);
        facilityInfo.setName(dataDict.getName());
        if (dataDict.getDataGroup() != null) {
            facilityInfo.setFacilityType(FacilityInfo.FacilityType.codeValueOf(dataDict.getDataGroup().getCode()));
        }
        return facilityInfo;
    }

    private DataDict map(FacilityInfo facilityInfo) {
        DataDict dataDict = new DataDict();
        BeanUtils.copyProperties(facilityInfo, dataDict);
        dataDict.setName(facilityInfo.getName());
        if (facilityInfo.getFacilityType() != null) {
            dataDict.setDataGroup(DataDict.DataGroupEnum.codeValueOf(facilityInfo.getFacilityType().getCode()));
        }
        return dataDict;
    }

}

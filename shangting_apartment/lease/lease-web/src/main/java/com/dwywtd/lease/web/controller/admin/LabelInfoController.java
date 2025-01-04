package com.dwywtd.lease.web.controller.admin;

import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.dto.LabelInfo;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.web.result.ResultBuild;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "标签管理")
@ResultBuild
@RestController
@RequestMapping("/admin/label")
public class LabelInfoController {

    private final DataDictService dataDictService;

    public LabelInfoController(DataDictService dataDictService) {
        this.dataDictService = dataDictService;
    }

    @Operation(summary = "（根据类型）查询标签列表")
    @GetMapping("list")
    public List<LabelInfo> labelList(@RequestParam(required = false) LabelInfo.LabelType labelType) {
        if (labelType == null) {
            List<DataDict.DataGroupEnum> dataGroupEnumList = Arrays.stream(LabelInfo.LabelType.values()).map(i -> {
                return DataDict.DataGroupEnum.codeValueOf(i.getCode());
            }).collect(Collectors.toList());
            return dataDictService.listByGroups(dataGroupEnumList).stream().map(this::map).collect(Collectors.toList());
        } else {
            List<DataDict> listByGroup = dataDictService.listByGroup(DataDict.DataGroupEnum.codeValueOf(labelType.getCode()));
            return listByGroup.stream().map(this::map).collect(Collectors.toList());
        }
    }

    @Operation(summary = "保存或更新标签信息")
    @PostMapping("saveOrUpdate")
    public LabelInfo saveOrUpdateFacility(@RequestBody LabelInfo labelInfo) {
        DataDict dataDict = map(labelInfo);
        if (labelInfo.getId() == null) {
            dataDictService.save(dataDict);
        } else {
            dataDictService.updateById(dataDict);
        }
        return map(dataDict);
    }

    @Operation(summary = "根据id删除标签信息")
    @DeleteMapping("deleteById")
    public void deleteLabelById(@RequestParam Long id) {
        dataDictService.removeById(id);
    }


    private DataDict map(LabelInfo labelInfo) {
        DataDict dataDict = new DataDict();
        BeanUtils.copyProperties(labelInfo, dataDict);
        dataDict.setId(labelInfo.getId());
        dataDict.setName(labelInfo.getName());
        dataDict.setDataValue(labelInfo.getName());
        dataDict.setDataGroup(DataDict.DataGroupEnum.codeValueOf(labelInfo.getType().getCode()));
        return dataDict;
    }

    private LabelInfo map(DataDict dataDict) {
        LabelInfo labelInfo = new LabelInfo();
        BeanUtils.copyProperties(dataDict, labelInfo);
        labelInfo.setId(dataDict.getId());
        labelInfo.setName(dataDict.getName());
        labelInfo.setType(LabelInfo.LabelType.codeValueOf(dataDict.getDataGroup().getCode()));
        return labelInfo;
    }

}

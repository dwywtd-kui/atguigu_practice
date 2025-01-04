package com.dwywtd.lease.web.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.domain.DataDictGroup;
import com.dwywtd.lease.business.dto.AttrKey;
import com.dwywtd.lease.business.dto.AttrValue;
import com.dwywtd.lease.business.service.DataDictGroupService;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.business.vo.AttrKeyVo;
import com.dwywtd.lease.web.result.ResultBuild;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "房间属性管理")
@ResultBuild
@RestController
@RequestMapping("/admin/attr")
public class AttrController {

    private final DataDictGroupService dataDictGroupService;

    private final DataDictService dataDictService;

    public AttrController(DataDictGroupService dataDictGroupService, DataDictService dataDictService) {
        this.dataDictGroupService = dataDictGroupService;
        this.dataDictService = dataDictService;
    }

    @Operation(summary = "保存或更新属性名称")
    @PostMapping("key/saveOrUpdate")
    public AttrKey saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        DataDictGroup dictGroup = map(attrKey);
        if (attrKey.getId() == null) {
            dataDictGroupService.save(dictGroup);
        } else {
            dataDictGroupService.updateById(dictGroup);
        }
        return map(dictGroup);
    }

    private DataDictGroup map(AttrKey attrKey) {
        DataDictGroup dataDictGroup = new DataDictGroup();
        BeanUtils.copyProperties(attrKey, dataDictGroup);
        dataDictGroup.setName(attrKey.getName());
        return dataDictGroup;
    }

    private AttrKey map(DataDictGroup dataDictGroup) {
        AttrKey attrKey = new AttrKey();
        BeanUtils.copyProperties(dataDictGroup, attrKey);
        attrKey.setName(dataDictGroup.getName());
        return attrKey;
    }

    private AttrKeyVo map2AttrKeyVo(DataDictGroup dataDictGroup) {
        AttrKeyVo attrKey = new AttrKeyVo();
        BeanUtils.copyProperties(dataDictGroup, attrKey);
        attrKey.setName(dataDictGroup.getName());
        return attrKey;
    }

    @Operation(summary = "保存或更新属性值")
    @PostMapping("value/saveOrUpdate")
    public AttrValue saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        DataDict dataDict = map(attrValue);
        if (attrValue.getId() == null) {
            dataDictService.save(dataDict);
        } else {
            dataDictService.updateById(dataDict);
        }
        return map(dataDict);
    }

    private DataDict map(AttrValue attrValue) {
        DataDict dataDict = new DataDict();
        BeanUtils.copyProperties(attrValue, dataDict);
        dataDict.setName(attrValue.getName());
        dataDict.setDataGroup(attrValue.getAttrKeyId());
        return dataDict;
    }

    private AttrValue map(DataDict dataDict) {
        AttrValue attrValue = new AttrValue();
        BeanUtils.copyProperties(dataDict, attrValue);
        attrValue.setName(dataDict.getName());
        attrValue.setAttrKeyId(dataDict.getDataGroup());
        return attrValue;
    }

    @Operation(summary = "查询全部属性名称和属性值列表")
    @GetMapping("list")
    public List<AttrKeyVo> listAttrInfo() {
        List<DataDictGroup> dictGroups = dataDictGroupService.list();
        List<AttrKeyVo> attrKeyVoList = dictGroups.stream().map(this::map2AttrKeyVo).toList();
        for (AttrKeyVo attrKeyVo : attrKeyVoList) {
            List<DataDict> dataDictList = dataDictService.listByGroup(String.valueOf(attrKeyVo.getId()));
            attrKeyVo.setAttrValueList(dataDictList.stream().map(this::map).toList());
        }
        return attrKeyVoList;
    }

    @Operation(summary = "根据id删除属性名称")
    @DeleteMapping("key/deleteById")
    public void removeAttrKeyById(@RequestParam Long attrKeyId) {
        LambdaQueryWrapper<DataDict> wrapper = new LambdaQueryWrapper<DataDict>();
        wrapper.eq(DataDict::getDataGroup, attrKeyId);
        dataDictService.remove(wrapper);
        dataDictGroupService.removeById(attrKeyId);
    }

    @Operation(summary = "根据id删除属性值")
    @DeleteMapping("value/deleteById")
    public void removeAttrValueById(@RequestParam Long id) {
        dataDictService.removeById(id);
    }
}

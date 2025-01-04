package com.dwywtd.lease.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.mapper.DataDictMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.DataDictService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataDictServiceImpl extends BaseService<DataDictMapper, DataDict> implements DataDictService {

    public DataDictServiceImpl(DataDictMapper mapper) {
        super(mapper);
    }


    @Override
    public List<DataDict> listByGroup(DataDict.DataGroupEnum dataGroup) {
        QueryWrapper<DataDict> queryWrapper = new QueryWrapper<>();
        return list(queryWrapper.eq("data_group", dataGroup.getCode()));
    }

    @Override
    public List<DataDict> listByGroups(List<DataDict.DataGroupEnum> dataGroups) {
        LambdaQueryWrapper<DataDict> queryWrapper = new LambdaQueryWrapper<>();
        List<String> codes = new ArrayList<>();
        for (DataDict.DataGroupEnum dataGroup : dataGroups) {
            codes.add(dataGroup.getCode());
        }
        if (codes.size() > 0) {
            queryWrapper.in(DataDict::getDataGroup, codes);
        }
        return list(queryWrapper);
    }
}

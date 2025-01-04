package com.dwywtd.lease.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.mapper.DataDictMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.DataDictService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataDictServiceImpl extends BaseService<DataDictMapper, DataDict> implements DataDictService {

    public DataDictServiceImpl(DataDictMapper mapper) {
        super(mapper);
    }


    @Override
    public List<DataDict> listByGroup(String dataGroup) {
        if (dataGroup == null) {
            return Collections.emptyList();
        }
        QueryWrapper<DataDict> queryWrapper = new QueryWrapper<>();
        return list(queryWrapper.eq("data_group", dataGroup));
    }

    @Override
    public List<DataDict> listByGroups(List<String> dataGroups) {
        if (CollectionUtils.isEmpty(dataGroups)) {
            return Collections.emptyList();
        }
        LambdaQueryWrapper<DataDict> queryWrapper = new LambdaQueryWrapper<>();
        if (dataGroups.size() > 0) {
            queryWrapper.in(DataDict::getDataGroup, dataGroups);
        }
        return list(queryWrapper);
    }

    @Override
    public List<DataDict> listByGroup(DataDict.DataGroupEnum dataGroup) {
        return listByGroup(dataGroup.getCode());
    }

    @Override
    public List<DataDict> listByDataGroupEnum(List<DataDict.DataGroupEnum> dataGroups) {
        List<String> codes = new ArrayList<>();
        for (DataDict.DataGroupEnum dataGroup : dataGroups) {
            codes.add(dataGroup.getCode());
        }
        return listByGroups(codes);
    }
}

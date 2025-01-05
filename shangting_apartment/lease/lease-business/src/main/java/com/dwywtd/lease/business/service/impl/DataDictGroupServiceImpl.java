package com.dwywtd.lease.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dwywtd.lease.business.domain.DataDictGroup;
import com.dwywtd.lease.business.mapper.DataDictGroupMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.DataDictGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictGroupServiceImpl extends BaseService<DataDictGroupMapper, DataDictGroup> implements DataDictGroupService {
    public DataDictGroupServiceImpl(DataDictGroupMapper mapper) {
        super(mapper);
    }

    @Override
    public List<DataDictGroup> listByClassify(String classify) {
        return mapper.selectList(new LambdaQueryWrapper<DataDictGroup>().eq(DataDictGroup::getClassify, classify));
    }
}

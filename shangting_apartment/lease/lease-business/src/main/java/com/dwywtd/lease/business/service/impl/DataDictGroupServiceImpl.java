package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.DataDictGroup;
import com.dwywtd.lease.business.mapper.DataDictGroupMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.DataDictGroupService;
import org.springframework.stereotype.Service;

@Service
public class DataDictGroupServiceImpl extends BaseService<DataDictGroupMapper, DataDictGroup> implements DataDictGroupService {
    public DataDictGroupServiceImpl(DataDictGroupMapper mapper) {
        super(mapper);
    }
}

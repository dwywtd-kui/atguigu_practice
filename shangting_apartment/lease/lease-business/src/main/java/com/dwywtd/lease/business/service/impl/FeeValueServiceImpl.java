package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.FeeValue;
import com.dwywtd.lease.business.mapper.FeeValueMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.FeeValueService;
import org.springframework.stereotype.Service;

@Service
public class FeeValueServiceImpl extends BaseService<FeeValueMapper, FeeValue> implements FeeValueService {
    public FeeValueServiceImpl(FeeValueMapper mapper) {
        super(mapper);
    }
}

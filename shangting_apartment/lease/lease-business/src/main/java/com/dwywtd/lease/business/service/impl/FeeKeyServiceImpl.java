package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.FeeKey;
import com.dwywtd.lease.business.mapper.FeeKeyMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.FeeKeyService;
import com.dwywtd.lease.business.vo.FeeKeyVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeKeyServiceImpl extends BaseService<FeeKeyMapper, FeeKey> implements FeeKeyService {
    public FeeKeyServiceImpl(FeeKeyMapper mapper) {
        super(mapper);
    }

    @Override
    public List<FeeKeyVo> getFeeKeyVoList() {
        return mapper.getFeeKeyVoList();
    }
}

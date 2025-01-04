package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.SystemPost;
import com.dwywtd.lease.business.mapper.SystemPostMapper;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.SystemPostService;
import org.springframework.stereotype.Service;

@Service
public class SystemPostServiceImpl extends BaseService<SystemPostMapper, SystemPost> implements SystemPostService {
    public SystemPostServiceImpl(SystemPostMapper mapper) {
        super(mapper);
    }
}

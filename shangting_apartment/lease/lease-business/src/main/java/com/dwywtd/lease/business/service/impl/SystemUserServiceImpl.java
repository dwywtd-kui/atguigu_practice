package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.SystemUser;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.SystemUserService;
import com.dwywtd.lease.business.mapper.SystemUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author 14320
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2024-12-30 23:05:39
 */
@Service
public class SystemUserServiceImpl extends BaseService<SystemUserMapper, SystemUser> implements SystemUserService {

    public SystemUserServiceImpl(SystemUserMapper mapper) {
        super(mapper);
    }

    @Override
    public SystemUser getByUsernameWithPassword(String username) {
        return mapper.getByUsernameWithPassword(username);
    }
}





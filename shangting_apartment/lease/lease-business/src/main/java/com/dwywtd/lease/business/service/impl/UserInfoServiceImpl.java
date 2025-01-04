package com.dwywtd.lease.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dwywtd.lease.business.domain.UserInfo;
import com.dwywtd.lease.business.service.BaseService;
import com.dwywtd.lease.business.service.UserInfoService;
import com.dwywtd.lease.business.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author 14320
 * @description 针对表【user_info(用户信息表)】的数据库操作Service实现
 * @createDate 2024-12-30 23:16:36
 */
@Service
public class UserInfoServiceImpl extends BaseService<UserInfoMapper, UserInfo>
        implements UserInfoService {

    public UserInfoServiceImpl(UserInfoMapper mapper) {
        super(mapper);
    }

    @Override
    public UserInfo getUserInfoByPhone(String phone) {
        return lambdaQuery().eq(UserInfo::getPhone, phone).getEntity();
    }
}





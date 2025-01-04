package com.dwywtd.lease.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dwywtd.lease.business.domain.UserInfo;

import java.util.List;

/**
 * @author 14320
 * @description 针对表【user_info(用户信息表)】的数据库操作Service
 * @createDate 2024-12-30 23:16:36
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getUserInfoByPhone(String phone);
}

package com.dwywtd.lease.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dwywtd.lease.business.domain.SystemUser;

/**
 * @author 14320
 * @description 针对表【system_user(员工信息表)】的数据库操作Service
 * @createDate 2024-12-30 23:05:39
 */
public interface SystemUserService extends IService<SystemUser> {

    SystemUser getByUsernameWithPassword(String username);
}

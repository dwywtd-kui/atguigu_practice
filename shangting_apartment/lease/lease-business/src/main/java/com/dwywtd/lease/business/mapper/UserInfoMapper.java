package com.dwywtd.lease.business.mapper;

import com.dwywtd.lease.business.domain.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 14320
 * @description 针对表【user_info(用户信息表)】的数据库操作Mapper
 * @createDate 2024-12-30 23:16:36
 * @Entity com.dwywtd.lease.business.domain.UserInfo
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}





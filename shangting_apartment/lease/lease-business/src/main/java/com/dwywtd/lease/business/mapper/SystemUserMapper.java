package com.dwywtd.lease.business.mapper;

import com.dwywtd.lease.business.domain.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 14320
 * @description 针对表【system_user(员工信息表)】的数据库操作Mapper
 * @createDate 2024-12-30 23:05:39
 * @Entity com.dwywtd.lease.service.domain.SystemUser
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    @Select("select * from system_user where username = #{username}")
    SystemUser getByUsernameWithPassword(@Param("username") String username);

}





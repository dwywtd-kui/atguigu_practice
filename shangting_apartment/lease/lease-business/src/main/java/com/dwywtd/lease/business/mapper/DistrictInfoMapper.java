package com.dwywtd.lease.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dwywtd.lease.business.domain.DistrictInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DistrictInfoMapper extends BaseMapper<DistrictInfo> {
}

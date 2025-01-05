package com.dwywtd.lease.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dwywtd.lease.business.domain.FeeKey;
import com.dwywtd.lease.business.vo.FeeKeyVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeeKeyMapper extends BaseMapper<FeeKey> {
    List<FeeKeyVo> getFeeKeyVoList();
}

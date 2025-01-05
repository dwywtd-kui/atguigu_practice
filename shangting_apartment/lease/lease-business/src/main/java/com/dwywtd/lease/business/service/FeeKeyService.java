package com.dwywtd.lease.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dwywtd.lease.business.domain.FeeKey;
import com.dwywtd.lease.business.vo.FeeKeyVo;

import java.util.List;

public interface FeeKeyService extends IService<FeeKey> {
    List<FeeKeyVo> getFeeKeyVoList();
}

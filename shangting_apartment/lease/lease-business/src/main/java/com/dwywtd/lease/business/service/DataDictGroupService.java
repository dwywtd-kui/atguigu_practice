package com.dwywtd.lease.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dwywtd.lease.business.domain.DataDictGroup;

import java.util.List;

public interface DataDictGroupService extends IService<DataDictGroup> {

    List<DataDictGroup> listByClassify(String classify);

}

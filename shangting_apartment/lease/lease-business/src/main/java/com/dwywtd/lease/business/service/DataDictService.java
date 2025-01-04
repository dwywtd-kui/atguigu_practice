package com.dwywtd.lease.business.service;

import com.dwywtd.lease.business.domain.DataDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 14320
 * @description 针对表【data_dict(支付方式表)】的数据库操作Service
 * @createDate 2025-01-01 21:38:26
 */
public interface DataDictService extends IService<DataDict> {

    List<DataDict> listByGroup(DataDict.DataGroupEnum dataGroup);

    List<DataDict> listByGroups(List<DataDict.DataGroupEnum> dataGroups);

}

package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.dto.LeaseTerm;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.business.service.LeaseTermService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaseTermServiceImpl implements LeaseTermService {

    @Autowired
    private DataDictService dataDictService;

    @Override
    public List<LeaseTerm> list() {
        List<DataDict> list = dataDictService.listByGroup(DataDict.DataGroupEnum.LEASE_TERM);
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public LeaseTerm saveOrUpdate(LeaseTerm leaseTerm) {
        DataDict dataDict = map(leaseTerm);
        if (leaseTerm.getId() == null) {
            dataDictService.updateById(dataDict);
        } else {
            dataDictService.save(dataDict);
        }
        return map(dataDict);
    }

    @Override
    public void removeById(Long id) {
        dataDictService.removeById(id);
    }

    private LeaseTerm map(DataDict dataDict) {
        LeaseTerm leaseTerm = new LeaseTerm();
        BeanUtils.copyProperties(dataDict, leaseTerm);
        leaseTerm.setName(dataDict.getName());
        return leaseTerm;
    }

    private DataDict map(LeaseTerm leaseTerm) {
        DataDict dataDict = new DataDict();
        BeanUtils.copyProperties(leaseTerm, dataDict);
        dataDict.setName(leaseTerm.getName());
        return dataDict;
    }
}

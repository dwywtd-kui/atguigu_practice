package com.dwywtd.lease.business.service;

import com.dwywtd.lease.business.dto.LeaseTerm;

import java.util.List;

public interface LeaseTermService {

    List<LeaseTerm> list();

    LeaseTerm saveOrUpdate(LeaseTerm leaseTerm);

    void removeById(Long id);
}

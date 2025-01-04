package com.dwywtd.lease.business.service;

import com.dwywtd.lease.business.dto.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    List<PaymentType> list();

    PaymentType saveOrUpdate(PaymentType paymentType);

    void removeById(Long id);
}

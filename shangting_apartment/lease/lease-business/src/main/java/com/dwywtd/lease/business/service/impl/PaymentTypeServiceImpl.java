package com.dwywtd.lease.business.service.impl;

import com.dwywtd.lease.business.domain.DataDict;
import com.dwywtd.lease.business.dto.PaymentType;
import com.dwywtd.lease.business.service.DataDictService;
import com.dwywtd.lease.business.service.PaymentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private DataDictService dataDictService;

    @Override
    public List<PaymentType> list() {
        List<DataDict> list = dataDictService.listByGroup(DataDict.DataGroupEnum.PAYMENT_TYPE);
        return list.stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public PaymentType saveOrUpdate(PaymentType paymentType) {
        DataDict dataDict = map(paymentType);
        if (paymentType.getId() != null) {
            dataDictService.updateById(map(paymentType));
        } else {
            dataDictService.save(map(paymentType));
        }
        return map(dataDict);
    }

    @Override
    public void removeById(Long id) {
        dataDictService.removeById(id);
    }

    private PaymentType map(DataDict dataDict) {
        PaymentType paymentType = new PaymentType();
        BeanUtils.copyProperties(dataDict, paymentType);
        paymentType.setName(dataDict.getName());
        paymentType.setPayMonthCount(dataDict.getDataValue());
        paymentType.setAdditionalInfo(dataDict.getDescription());
        return paymentType;
    }

    private DataDict map(PaymentType paymentType) {
        DataDict dataDict = new DataDict();
        BeanUtils.copyProperties(paymentType, dataDict);
        dataDict.setName(paymentType.getName());
        dataDict.setDataValue(paymentType.getPayMonthCount());
        dataDict.setDescription(paymentType.getAdditionalInfo());
        return dataDict;
    }
}

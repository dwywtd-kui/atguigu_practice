package com.dwywtd.lease.business.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public abstract class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    protected final M mapper;

    public BaseService(M mapper) {
        this.mapper = mapper;
    }
}

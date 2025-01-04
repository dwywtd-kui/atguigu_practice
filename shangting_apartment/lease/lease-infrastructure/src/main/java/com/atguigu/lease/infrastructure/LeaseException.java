package com.atguigu.lease.infrastructure;

import com.atguigu.lease.infrastructure.result.ResultCodeEnum;

import java.io.Serializable;

public class LeaseException extends RuntimeException implements Serializable {

    public LeaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
    }
}

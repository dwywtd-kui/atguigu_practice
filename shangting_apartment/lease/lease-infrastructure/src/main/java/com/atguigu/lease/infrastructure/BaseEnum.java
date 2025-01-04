package com.atguigu.lease.infrastructure;

import java.io.Serializable;

public interface BaseEnum<T extends Serializable> {
    T getCode();

    String getName();
}

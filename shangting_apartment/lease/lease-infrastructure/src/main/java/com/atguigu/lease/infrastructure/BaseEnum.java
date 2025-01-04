package com.atguigu.lease.infrastructure;

import com.baomidou.mybatisplus.annotation.IEnum;

public interface BaseEnum extends IEnum<String> {
    String getCode();

    String getName();
}

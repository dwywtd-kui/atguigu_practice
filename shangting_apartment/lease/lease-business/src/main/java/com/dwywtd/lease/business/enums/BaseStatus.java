package com.dwywtd.lease.business.enums;

import com.atguigu.lease.infrastructure.BaseEnum;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum BaseStatus implements BaseEnum<Integer>, IEnum<Integer> {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    @JsonValue
    private final Integer code;
    private final String name;

    BaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return getCode();
    }
}

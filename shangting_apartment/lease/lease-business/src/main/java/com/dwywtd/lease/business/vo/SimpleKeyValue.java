package com.dwywtd.lease.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleKeyValue<T> {
    private String key;
    private T value;
}

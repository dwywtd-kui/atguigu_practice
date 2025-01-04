package com.dwywtd.lease.business.dto;

import com.atguigu.lease.infrastructure.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttrKey extends BaseDto {
    private String name;
}

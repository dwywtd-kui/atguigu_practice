package com.dwywtd.lease.business.dto;

import com.atguigu.lease.infrastructure.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeaseTerm extends BaseDto {
    private String name;
}

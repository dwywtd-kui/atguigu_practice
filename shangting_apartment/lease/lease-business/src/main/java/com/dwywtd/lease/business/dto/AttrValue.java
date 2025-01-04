package com.dwywtd.lease.business.dto;

import com.atguigu.lease.infrastructure.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttrValue extends BaseDto {
    private String name;
    private String attrKeyId;
}

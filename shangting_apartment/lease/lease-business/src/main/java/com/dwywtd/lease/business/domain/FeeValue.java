package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("fee_value")
@Data
@EqualsAndHashCode(callSuper = true)
public class FeeValue extends BaseEntity {
    private String name;
    private String unit;
    private String feeKeyId;
}

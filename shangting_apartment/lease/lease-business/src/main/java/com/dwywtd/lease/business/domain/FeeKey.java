package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


@TableName("fee_key")
@Data
@EqualsAndHashCode(callSuper = true)
public class FeeKey extends BaseEntity {
    private String name;
}

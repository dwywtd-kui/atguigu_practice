package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("district_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class DistrictInfo extends BaseEntity {
    private String name;

    private Integer cityId;
}

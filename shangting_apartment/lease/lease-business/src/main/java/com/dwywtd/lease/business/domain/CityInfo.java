package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("city_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class CityInfo extends BaseEntity {
    private String name;

    private Integer provinceId;
}

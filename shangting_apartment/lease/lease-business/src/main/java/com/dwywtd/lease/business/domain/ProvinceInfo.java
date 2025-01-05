package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("province_info")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProvinceInfo extends BaseEntity {
    private String name;
}

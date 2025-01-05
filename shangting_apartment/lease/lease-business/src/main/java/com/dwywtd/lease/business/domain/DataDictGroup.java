package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

@Tag(name = "数据字典分组")
@TableName("data_dict_group")
@Data
public class DataDictGroup extends BaseEntity {

    private String classify;

    private String code;

    private String name;

    private String description;

    // 不关联数据库的字段
    @TableField(exist = false)
    private List<DataDict> dataDictList;
}

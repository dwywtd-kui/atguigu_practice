package com.atguigu.lease.infrastructure;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {
    // 主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    // 创建时间
    @TableField(fill = FieldFill.INSERT, value = "create_time")
    @JsonIgnore
    private Date createTime;

    // 更新时间
    @TableField(fill = FieldFill.UPDATE, value = "update_time")
    @JsonIgnore
    private Date updateTime;

    // 删除标记
    @TableLogic(value = "0", delval = "1")
    @TableField(value = "is_deleted")
    @JsonIgnore
    private Integer deleted;
}

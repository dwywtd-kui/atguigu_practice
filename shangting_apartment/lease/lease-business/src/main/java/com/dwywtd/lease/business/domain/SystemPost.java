package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwywtd.lease.business.enums.BaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "系统岗位")
@TableName("system_post")
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemPost extends BaseEntity {

    @Schema(description = "岗位编码")
    private String code;

    @Schema(description = "岗位名称")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "状态")
    private BaseStatus status;
}

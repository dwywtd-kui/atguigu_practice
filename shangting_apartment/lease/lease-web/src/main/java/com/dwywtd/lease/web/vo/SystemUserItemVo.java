package com.dwywtd.lease.web.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dwywtd.lease.business.domain.SystemUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "后台管理系统用户基本信息实体")
public class SystemUserItemVo extends SystemUser {

    @Schema(description = "岗位名称")
    @TableField(value = "post_name")
    private String postName;
}
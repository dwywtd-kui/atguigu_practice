package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwywtd.lease.business.enums.BaseStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 员工信息表
 *
 * @TableName system_user
 */
@TableName(value = "system_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class SystemUser extends BaseEntity implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @TableField(select = false)
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 备注信息
     */
    private String additionalInfo;

    /**
     * 岗位id
     */
    private Long postId;

    /**
     * 账号状态
     */
    private BaseStatus status;

}
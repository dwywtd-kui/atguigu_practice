package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dwywtd.lease.business.enums.BaseStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @TableName user_info
 */
@Data
@TableName("user_info")
public class UserInfo extends BaseEntity {

    /**
     * 手机号码（用做登录用户名）
     */
    private String phone;

    /**
     * 密码
     */
    @TableField(select = false)
    private String password;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 账号状态
     */
    private BaseStatus status;
}
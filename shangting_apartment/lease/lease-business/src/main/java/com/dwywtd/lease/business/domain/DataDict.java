package com.dwywtd.lease.business.domain;

import com.atguigu.lease.infrastructure.BaseEntity;
import com.atguigu.lease.infrastructure.BaseEnum;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 支付方式表
 *
 * @TableName data_dict
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("data_dict")
public class DataDict extends BaseEntity {

    private DataGroupEnum dataGroup;

    /**
     * 名称
     */
    private String name;

    /**
     * 数据值
     */
    private String dataValue;

    /**
     * 显示icon
     */
    private String icon;

    /**
     * 描述
     */
    private String description;


    @Getter
    public enum DataGroupEnum implements BaseEnum {
        PAYMENT_TYPE("payment_type", "支付方式"),
        LEASE_TERM("lease_term", "租期"),
        LABEL_APARTMENT("label_apartment", "公寓标签"),
        LABEL_ROOM("label_room", "房间标签"),
        FACILITY_APARTMENT("facility_apartment", "公寓配套"),
        FACILITY_ROOM("facility_room", "房间配套");

        @JsonValue
        private final String code;
        private final String name;

        DataGroupEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String getValue() {
            return getCode();
        }

        public static DataGroupEnum codeValueOf(String code) {
            for (DataGroupEnum dataGroupEnum : values()) {
                if (dataGroupEnum.getCode().equals(code)) {
                    return dataGroupEnum;
                }
            }
            throw new IllegalArgumentException("非法的枚举值:" + code);
        }
    }

}
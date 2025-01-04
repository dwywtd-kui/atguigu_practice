package com.dwywtd.lease.business.dto;

import com.atguigu.lease.infrastructure.BaseDto;
import com.atguigu.lease.infrastructure.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Schema(description = "标签信息")
@EqualsAndHashCode
@Data
public class LabelInfo extends BaseDto {

    @Schema(description = "类型")
    private LabelType type;

    @Schema(description = "标签名称")
    private String name;



    @Schema(description = "标签类型")
    @Getter
    public enum LabelType implements BaseEnum {
        APARTMENT("label_department", "公寓标签"),
        ROOM("label_room", "房间标签");

        @JsonValue
        private final String code;
        private final String name;

        LabelType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public String getValue() {
            return getCode();
        }

        public static LabelType codeValueOf(String code) {
            for (LabelType labelType : values()) {
                if (labelType.getCode().equals(code)) {
                    return labelType;
                }
            }
            throw new IllegalArgumentException("非法的枚举值:" + code);
        }
    }
}

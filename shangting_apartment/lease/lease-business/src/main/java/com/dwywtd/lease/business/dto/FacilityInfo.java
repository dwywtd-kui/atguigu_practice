package com.dwywtd.lease.business.dto;

import com.atguigu.lease.infrastructure.BaseDto;
import com.atguigu.lease.infrastructure.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Schema(description = "配套信息")
@EqualsAndHashCode
@Data
public class FacilityInfo extends BaseDto {

    @Schema(description = "配套类型")
    private FacilityType facilityType;

    @Schema(description = "配套名称")
    private String name;

    @Schema(description = "图标")
    private String icon;


    @Getter
    public enum FacilityType implements BaseEnum {
        APARTMENT("facility_apartment", "公寓配套"),
        ROOM("facility_room", "房间配套");

        @JsonValue
        private final String code;
        private final String name;

        FacilityType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getValue() {
            return code;
        }

        public static FacilityType codeValueOf(String code) {
            for (FacilityType facilityType : FacilityType.values()) {
                if (facilityType.code.equals(code)) {
                    return facilityType;
                }
            }
            throw new IllegalArgumentException("非法的枚举值:" + code);
        }
    }

}

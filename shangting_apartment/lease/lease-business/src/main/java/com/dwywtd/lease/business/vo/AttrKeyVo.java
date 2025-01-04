package com.dwywtd.lease.business.vo;

import com.dwywtd.lease.business.dto.AttrKey;
import com.dwywtd.lease.business.dto.AttrValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class AttrKeyVo extends AttrKey {

    @Schema(description = "属性值列表")
    private List<AttrValue> attrValueList;
}

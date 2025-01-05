package com.dwywtd.lease.business.vo;

import com.dwywtd.lease.business.domain.FeeKey;
import com.dwywtd.lease.business.domain.FeeValue;
import lombok.Data;

import java.util.List;

@Data
public class FeeKeyVo extends FeeKey {
    List<FeeValue> feeValueList;
}

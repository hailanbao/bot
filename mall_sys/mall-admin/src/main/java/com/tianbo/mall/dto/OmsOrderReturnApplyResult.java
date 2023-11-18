package com.tianbo.mall.dto;

import com.tianbo.mall.modules.oms.model.OmsCompanyAddress;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}

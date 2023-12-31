package com.tianbo.mall.dto;

import com.tianbo.mall.modules.oms.model.OmsOrder;
import com.tianbo.mall.modules.oms.model.OmsOrderItem;
import com.tianbo.mall.modules.oms.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}

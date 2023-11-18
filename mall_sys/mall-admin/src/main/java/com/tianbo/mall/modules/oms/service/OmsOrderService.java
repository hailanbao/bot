package com.tianbo.mall.modules.oms.service;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.*;
import com.tianbo.mall.modules.oms.model.OmsOrder;
import com.tianbo.mall.modules.product.model.PmsProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderService extends IService<OmsOrder>{
    /**
     * 订单查询
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量发货
     */
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
//    @Transactional
//    int close(List<Long> ids, String note);

    /**
     * 批量删除订单
     */
//    boolean removeByIds(List<Long> ids, SFunction<PmsProduct, ?> getPublishStatus);

    /**
     * 获取指定订单详情
     */
    OmsOrderDetail detail(Long id);

    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    /**
     * 修改订单费用信息
     */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);

}

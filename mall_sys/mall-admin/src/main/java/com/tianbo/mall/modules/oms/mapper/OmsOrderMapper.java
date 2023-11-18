package com.tianbo.mall.modules.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.dto.OmsOrderDeliveryParam;
import com.tianbo.mall.dto.OmsOrderDetail;
import com.tianbo.mall.dto.OmsOrderQueryParam;
import com.tianbo.mall.modules.oms.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderMapper extends BaseMapper<OmsOrder> {

    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);

    int updateByPrimaryKeySelective(OmsOrder record);

}

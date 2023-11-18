package com.tianbo.mall.modules.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnReason;

/**
 * <p>
 * 退货原因表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderReturnReasonMapper extends BaseMapper<OmsOrderReturnReason> {

    int updateByPrimaryKey(OmsOrderReturnReason record);

    OmsOrderReturnReason selectByPrimaryKey(Long id);
}

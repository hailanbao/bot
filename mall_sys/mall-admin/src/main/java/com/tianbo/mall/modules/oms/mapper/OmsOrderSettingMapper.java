package com.tianbo.mall.modules.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.modules.oms.model.OmsOrderSetting;

/**
 * <p>
 * 订单设置表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderSettingMapper extends BaseMapper<OmsOrderSetting> {

    OmsOrderSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKey(OmsOrderSetting record);
}

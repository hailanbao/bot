package com.tianbo.mall.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.modules.oms.model.OmsOrderSetting;

/**
 * <p>
 * 订单设置表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderSettingService extends IService<OmsOrderSetting> {

    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OmsOrderSetting orderSetting);
}

package com.tianbo.mall.modules.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.HomeGoodsSaleDTO;
import com.tianbo.mall.modules.sms.model.SmsHomeCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface SmsHomeCategoryService extends IService<SmsHomeCategory> {

    List<HomeGoodsSaleDTO> getGoodsSale();
}

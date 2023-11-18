package com.tianbo.mall.modules.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.modules.sms.model.SmsHomeCategory;
import com.tianbo.mall.dto.HomeGoodsSaleDTO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface SmsHomeCategoryMapper extends BaseMapper<SmsHomeCategory> {

    List<HomeGoodsSaleDTO> getHomeCategoryWithProduct();
}

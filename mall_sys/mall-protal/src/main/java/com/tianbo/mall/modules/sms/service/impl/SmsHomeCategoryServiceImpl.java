package com.tianbo.mall.modules.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianbo.mall.dto.HomeGoodsSaleDTO;
import com.tianbo.mall.modules.sms.mapper.SmsHomeCategoryMapper;
import com.tianbo.mall.modules.sms.model.SmsHomeCategory;
import com.tianbo.mall.modules.sms.service.SmsHomeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class SmsHomeCategoryServiceImpl extends ServiceImpl<SmsHomeCategoryMapper, SmsHomeCategory> implements SmsHomeCategoryService {

    @Autowired
    SmsHomeCategoryMapper homeCategoryMapper;

    @Override
    public List<HomeGoodsSaleDTO> getGoodsSale() {
        return homeCategoryMapper.getHomeCategoryWithProduct();
    }
}

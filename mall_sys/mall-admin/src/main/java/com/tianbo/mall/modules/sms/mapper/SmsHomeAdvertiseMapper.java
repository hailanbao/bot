package com.tianbo.mall.modules.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.modules.sms.model.SmsHomeAdvertise;
import com.tianbo.mall.modules.sms.model.SmsHomeAdvertiseExample;

import java.util.List;

/**
 * <p>
 * 首页轮播广告表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-26
 */
public interface SmsHomeAdvertiseMapper extends BaseMapper<SmsHomeAdvertise> {

    int deleteByExample(SmsHomeAdvertiseExample example);

    int updateByPrimaryKeySelective(SmsHomeAdvertise record);

    List<SmsHomeAdvertise> selectByExample(SmsHomeAdvertiseExample example);

    SmsHomeAdvertise selectByPrimaryKey(Long id);
}

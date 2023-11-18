package com.tianbo.mall.modules.sms.service;

import com.tianbo.mall.modules.sms.model.SmsHomeAdvertise;

import java.util.List;

/**
 * <p>
 * 首页轮播广告表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-26
 */
public interface SmsHomeAdvertiseService{
    /**
     * 添加广告
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * 批量删除广告
     */
    int delete(List<Long> ids);

    /**
     * 修改上、下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * 更新广告
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * 分页查询广告
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}

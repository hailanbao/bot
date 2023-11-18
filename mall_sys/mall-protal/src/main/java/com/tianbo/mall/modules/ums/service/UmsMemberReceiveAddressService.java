package com.tianbo.mall.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.modules.ums.model.UmsMemberReceiveAddress;

import java.util.List;

/**
 * <p>
 * 会员收货地址表 服务类
 * </p>
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddress> {

    Boolean add(UmsMemberReceiveAddress address);

    Boolean edit(UmsMemberReceiveAddress address);

    Boolean delete(Long id);

    List<UmsMemberReceiveAddress> listByMemberId();
}

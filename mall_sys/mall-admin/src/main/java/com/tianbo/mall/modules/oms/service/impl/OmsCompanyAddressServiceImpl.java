package com.tianbo.mall.modules.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianbo.mall.modules.oms.mapper.OmsCompanyAddressMapper;
import com.tianbo.mall.modules.oms.model.OmsCompanyAddress;
import com.tianbo.mall.modules.oms.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 公司收发货地址表 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
@Service
public class OmsCompanyAddressServiceImpl extends ServiceImpl<OmsCompanyAddressMapper, OmsCompanyAddress> implements OmsCompanyAddressService {
}

package com.tianbo.mall.modules.pms.service.impl;

import com.tianbo.mall.modules.pms.model.PmsProduct;
import com.tianbo.mall.modules.pms.mapper.PmsProductMapper;
import com.tianbo.mall.dto.ProductDetailDTO;
import com.tianbo.mall.modules.pms.service.PmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 */
@Service
public class ProtalPmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Autowired
    PmsProductMapper productMapper;

    /**
     * 取商品详情获
     * @param id 商品id
     * @return
     */
    @Override
    public ProductDetailDTO getProductDetail(Long id) {
        return productMapper.getProductDetail(id);
    }
}

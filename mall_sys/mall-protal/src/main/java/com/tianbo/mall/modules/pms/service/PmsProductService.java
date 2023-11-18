package com.tianbo.mall.modules.pms.service;

import com.tianbo.mall.modules.pms.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.ProductDetailDTO;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 */
public interface PmsProductService extends IService<PmsProduct> {

    /**
     * 取商品详情获
     * @param id 商品id
     * @return
     */
    ProductDetailDTO getProductDetail(Long id);
}

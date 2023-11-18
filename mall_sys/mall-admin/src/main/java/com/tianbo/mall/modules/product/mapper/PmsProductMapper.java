package com.tianbo.mall.modules.product.mapper;

import com.tianbo.mall.dto.ProductUpdateInitDTO;
import com.tianbo.mall.modules.product.model.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    ProductUpdateInitDTO getUpdateInfo(Long id);
}

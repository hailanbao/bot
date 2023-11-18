package com.tianbo.mall.modules.product.service;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.ProductConditionDTO;
import com.tianbo.mall.dto.ProductSaveParamsDTO;
import com.tianbo.mall.dto.ProductUpdateInitDTO;
import com.tianbo.mall.modules.product.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductService extends IService<PmsProduct> {

    Page list(ProductConditionDTO productConditionDTO);

    boolean updateStatus(Integer publishStatus, List<Long> ids, SFunction<PmsProduct, ?> getPublishStatus);

    boolean create(ProductSaveParamsDTO productSaveParamsDTO);

    ProductUpdateInitDTO getUpdateInfo(Long id);

    boolean update(ProductSaveParamsDTO productSaveParamsDTO);

}

package com.tianbo.mall.modules.product.mapper;

import com.tianbo.mall.dto.ProductCateChildrenDTO;
import com.tianbo.mall.modules.product.model.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory> {

    List<ProductCateChildrenDTO> getListWithChildren();
}

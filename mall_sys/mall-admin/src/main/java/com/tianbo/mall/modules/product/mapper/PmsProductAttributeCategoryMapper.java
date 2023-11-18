package com.tianbo.mall.modules.product.mapper;

import com.tianbo.mall.dto.ProductAttributeCateDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductAttributeCategoryMapper extends BaseMapper<PmsProductAttributeCategory> {

    List<ProductAttributeCateDTO> getListWithAttr();
}

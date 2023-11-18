package com.tianbo.mall.modules.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.ProductAttributeCateDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategory> {
    Page list(Integer pageNum, Integer pageSize);

    boolean add(PmsProductAttributeCategory pmsProductAttributeCategory);

    List<ProductAttributeCateDTO> getListAttr();
}

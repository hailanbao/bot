package com.tianbo.mall.modules.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.PmsProductCategoryDTO;
import com.tianbo.mall.dto.ProductCateChildrenDTO;
import com.tianbo.mall.modules.product.model.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {

    Page list(Long parentId, Integer pageNum, Integer pageSize);

    boolean updateNavStatus(List<Long> ids, Integer navStatus);

    boolean updateShowStatus(List<Long> ids, Integer showStatus);

    boolean saveCustom(PmsProductCategoryDTO pmsProductCategoryDTO);

    boolean update(PmsProductCategoryDTO productCategoryDTO);

    List<ProductCateChildrenDTO> getListWithChildren();
}

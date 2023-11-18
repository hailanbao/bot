package com.tianbo.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.ProductAttributeCateDTO;
import com.tianbo.mall.modules.product.mapper.PmsProductAttributeCategoryMapper;
import com.tianbo.mall.modules.product.model.PmsProductAttributeCategory;
import com.tianbo.mall.modules.product.service.PmsProductAttributeCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {
    @Autowired
    PmsProductAttributeCategoryMapper attributeCategoryMapper;
    @Override
    public Page list(Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum,pageSize);
        return this.page(page);
    }

    @Override
    public boolean add(PmsProductAttributeCategory pmsProductAttributeCategory) {
        pmsProductAttributeCategory.setAttributeCount(0);
        pmsProductAttributeCategory.setParamCount(0);
        return this.save(pmsProductAttributeCategory);
    }

    @Override
    public List<ProductAttributeCateDTO> getListAttr() {
        return attributeCategoryMapper.getListWithAttr();
    }
}

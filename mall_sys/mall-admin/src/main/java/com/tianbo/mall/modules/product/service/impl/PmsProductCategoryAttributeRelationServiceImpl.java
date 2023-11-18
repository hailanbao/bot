package com.tianbo.mall.modules.product.service.impl;

import com.tianbo.mall.modules.product.mapper.PmsProductCategoryAttributeRelationMapper;
import com.tianbo.mall.modules.product.model.PmsProductCategoryAttributeRelation;
import com.tianbo.mall.modules.product.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}

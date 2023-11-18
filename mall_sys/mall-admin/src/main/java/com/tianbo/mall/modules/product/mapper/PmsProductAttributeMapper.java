package com.tianbo.mall.modules.product.mapper;

import com.tianbo.mall.dto.RelationAttrInfoDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductAttributeMapper extends BaseMapper<PmsProductAttribute> {

    List<RelationAttrInfoDTO> getRelationAttrInfoByCid(Long cId);
}

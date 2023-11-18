package com.tianbo.mall.modules.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.RelationAttrInfoDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttribute;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsProductAttributeService extends IService<PmsProductAttribute> {

    Page list(Long cid,Integer type, Integer pageNum, Integer pageSize);

    boolean create(PmsProductAttribute pmsProductAttribute);

    boolean delete(List<Long> id);

    List<RelationAttrInfoDTO> getRelationAttrInfoByCid(Long cId);
}

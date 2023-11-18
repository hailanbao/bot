package com.tianbo.mall.modules.pms.mapper;

import com.tianbo.mall.modules.pms.model.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.dto.HomeMenusDTO;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 */
public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory> {

    List<HomeMenusDTO> getProductWithCategory();
}

package com.tianbo.mall.modules.pms.service;

import com.tianbo.mall.dto.HomeMenusDTO;
import com.tianbo.mall.modules.pms.model.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {

    List<HomeMenusDTO> getMenus();
}

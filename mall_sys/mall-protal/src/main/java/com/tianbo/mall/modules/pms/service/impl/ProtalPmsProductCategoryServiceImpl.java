package com.tianbo.mall.modules.pms.service.impl;

import com.tianbo.mall.modules.pms.mapper.PmsProductCategoryMapper;
import com.tianbo.mall.modules.pms.model.PmsProductCategory;
import com.tianbo.mall.dto.HomeMenusDTO;
import com.tianbo.mall.modules.pms.service.PmsProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 */
@Service
public class ProtalPmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    @Autowired
    PmsProductCategoryMapper mapper;
    /**
     * 获取首页类型导航菜单
     * @return
     */
    @Override
    public List<HomeMenusDTO> getMenus() {
        return mapper.getProductWithCategory();
    }
}

package com.tianbo.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.PmsProductCategoryDTO;
import com.tianbo.mall.modules.product.mapper.PmsBrandMapper;
import com.tianbo.mall.modules.product.model.PmsBrand;
import com.tianbo.mall.modules.product.model.PmsProductCategory;
import com.tianbo.mall.modules.product.model.PmsProductCategoryAttributeRelation;
import com.tianbo.mall.modules.product.service.PmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Override
    public Page list(String keyword, Integer pageNum, Integer pageSize) {
        Page page=new Page(pageNum,pageSize);

        QueryWrapper<PmsBrand> pmsBrandQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)){
            pmsBrandQueryWrapper.lambda().like(PmsBrand::getName,keyword);
        }
        pmsBrandQueryWrapper.lambda().orderByAsc(PmsBrand::getSort);

        return this.page(page,pmsBrandQueryWrapper);
    }

    @Override
    public boolean update(PmsBrand pmsBrand) {
            this.updateById(pmsBrand);
            return true;
        }

    @Override
    public boolean updateShowStatus(List<Long> ids, Integer showStatus) {
        UpdateWrapper<PmsBrand> pmsBrandUpdateWrapper = new UpdateWrapper<>();

        pmsBrandUpdateWrapper.lambda()
                //需要更新的列
                .set(PmsBrand::getShowStatus,showStatus)
                //根据id修改
                .in(PmsBrand::getId,ids);

        return this.update(pmsBrandUpdateWrapper);
    }

    @Override
    public boolean updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        UpdateWrapper<PmsBrand> pmsBrandUpdateWrapper = new UpdateWrapper<>();

        pmsBrandUpdateWrapper.lambda()
                //需要更新的列
                .set(PmsBrand::getFactoryStatus,factoryStatus)
                //根据id修改
                .in(PmsBrand::getId,ids);

        return this.update(pmsBrandUpdateWrapper);
    }
}

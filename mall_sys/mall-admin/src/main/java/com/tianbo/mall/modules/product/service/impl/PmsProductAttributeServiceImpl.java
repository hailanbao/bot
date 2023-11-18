package com.tianbo.mall.modules.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.dto.RelationAttrInfoDTO;
import com.tianbo.mall.modules.product.mapper.PmsProductAttributeMapper;
import com.tianbo.mall.modules.product.model.PmsProductAttribute;
import com.tianbo.mall.modules.product.model.PmsProductAttributeCategory;
import com.tianbo.mall.modules.product.service.PmsProductAttributeCategoryService;
import com.tianbo.mall.modules.product.service.PmsProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Service
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeMapper, PmsProductAttribute> implements PmsProductAttributeService {
    @Autowired
    PmsProductAttributeMapper productAttributeMapper;
    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @Override
    public Page list(Long cid, Integer type, Integer pageNum, Integer pageSize) {
            Page page = new Page(pageNum,pageSize);
            //条件构造器
            QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("parentId",parentId);
            queryWrapper.lambda().eq(PmsProductAttribute::getProductAttributeCategoryId,cid).eq(PmsProductAttribute::getType,type)
            .orderByAsc(PmsProductAttribute::getSort);
            return page(page,queryWrapper);
        }

    @Override
    public boolean create(PmsProductAttribute pmsProductAttribute) {
        //保存商品属性
        boolean save = this.save(pmsProductAttribute);
        if(save){
            //更新对应属性、参数数量
            UpdateWrapper<PmsProductAttributeCategory> updateWrapper = new UpdateWrapper<>();
            if(pmsProductAttribute.getType()==0){
                updateWrapper.setSql("attribute_count=attribute_count+1");
            }
            else if(pmsProductAttribute.getType()==1){
                updateWrapper.setSql("param_count=param_count+1");
            }
            updateWrapper.lambda().eq(PmsProductAttributeCategory::getId,pmsProductAttribute.getProductAttributeCategoryId());
            pmsProductAttributeCategoryService.update(updateWrapper);
        }
        return save;
    }

    @Override
    public boolean delete(List<Long> id) {
        if(CollectionUtils.isEmpty(id)){
            return false;
        }
        PmsProductAttribute productAttribute = null;
        for (Long aLong : id) {
            productAttribute = this.getById(aLong);
            if (productAttribute!=null){
                break;
            }
        }

        int Length = productAttributeMapper.deleteBatchIds(id);

        if (Length>0 && productAttribute!=null){
            UpdateWrapper<PmsProductAttributeCategory> updateWrapper = new UpdateWrapper<>();
            if(productAttribute.getType()==0){
                updateWrapper.setSql("attribute_count=attribute_count-"+Length);
            }
            else if(productAttribute.getType()==1){
                updateWrapper.setSql("param_count=param_count-"+Length);
            }
            updateWrapper.lambda().eq(PmsProductAttributeCategory::getId,productAttribute.getProductAttributeCategoryId());
            pmsProductAttributeCategoryService.update(updateWrapper);
        }
        return Length>0;
    }

    @Override
    public List<RelationAttrInfoDTO> getRelationAttrInfoByCid(Long cId) {
        return productAttributeMapper.getRelationAttrInfoByCid(cId);
    }
}

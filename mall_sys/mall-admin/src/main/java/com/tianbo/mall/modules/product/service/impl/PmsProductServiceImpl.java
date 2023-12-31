package com.tianbo.mall.modules.product.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.ProductConditionDTO;
import com.tianbo.mall.dto.ProductSaveParamsDTO;
import com.tianbo.mall.dto.ProductUpdateInitDTO;
import com.tianbo.mall.modules.product.mapper.PmsProductMapper;
import com.tianbo.mall.modules.product.model.PmsProduct;
import com.tianbo.mall.modules.product.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {
    @Autowired
    PmsProductMapper productMapper;

    @Autowired
    PmsMemberPriceService memberPriceService;
    @Autowired
    PmsProductLadderService productLadderService;
    @Autowired
    PmsProductFullReductionService productFullReductionService;
    @Autowired
    PmsSkuStockService skuStockService;
    @Autowired
    PmsProductAttributeValueService productAttributeValueService;


    @Override
    public Page list(ProductConditionDTO productConditionDTO) {
        Page page = new Page(productConditionDTO.getPageNum(), productConditionDTO.getPageSize());
        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProduct> lambda = queryWrapper.lambda();
        //通过商品名称查询
        if(!StrUtil.isBlank(productConditionDTO.getKeyword())){
            lambda.like(PmsProduct::getName,productConditionDTO.getKeyword());
        }
        //通过商品货号查询
        if(!StrUtil.isBlank(productConditionDTO.getProductSn())){
            lambda.eq(PmsProduct::getProductSn,productConditionDTO.getProductSn());
        }
        //通过商品分类查询
        if(productConditionDTO.getProductCategoryId()!=null&&productConditionDTO.getProductCategoryId()>0){
            lambda.eq(PmsProduct::getProductCategoryId,productConditionDTO.getProductCategoryId());
        }
        //通过商品品牌查询
        if(productConditionDTO.getBrandId()!=null&&productConditionDTO.getBrandId()>0){
            lambda.like(PmsProduct::getBrandId,productConditionDTO.getBrandId());
        }
        //上架状态
        if(productConditionDTO.getPublishStatus()!=null){
            lambda.eq(PmsProduct::getPublishStatus,productConditionDTO.getPublishStatus());
        }
        //审核状态
        if(productConditionDTO.getVerifyStatus()!=null){
            lambda.like(PmsProduct::getVerifyStatus,productConditionDTO.getVerifyStatus());
        }
        lambda.orderByAsc(PmsProduct::getSort);
        return this.page(page,lambda);
    }

    @Override
    public boolean updateStatus(Integer status, List<Long> ids, SFunction<PmsProduct, ?> getPublishStatus) {
        UpdateWrapper<PmsProduct> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(getPublishStatus,status)
                .in(PmsProduct::getId,ids);   // where in (ids)
        return this.update(updateWrapper);
    }

    /**
     * 添加
     * @param productSaveParamsDTO
     * @return
     */
    @Override
    @Transactional
    public boolean create(ProductSaveParamsDTO productSaveParamsDTO) {
        // 1. 保存商品基本信息 --商品主表
        PmsProduct product=productSaveParamsDTO;
        product.setId(null);
        boolean result = this.save(product);
        if(result) {

            // 为了解决 前端会传入其他促销方式的空数据进来
            switch (product.getPromotionType()) {
                case 2:
                    // 2. 会员价格
                    SaveManyList(productSaveParamsDTO.getMemberPriceList(), product.getId(), memberPriceService);
                    break;
                case 3:
                    // 3. 阶梯价格
                    SaveManyList(productSaveParamsDTO.getProductLadderList(), product.getId(), productLadderService);
                    break;
                case 4:
                    // 4. 减满价格
                    SaveManyList(productSaveParamsDTO.getProductFullReductionList(), product.getId(), productFullReductionService);
                    break;
            }
            // 5. sku
            SaveManyList(productSaveParamsDTO.getSkuStockList(),product.getId(), skuStockService);

            // 6 spu
            SaveManyList(productSaveParamsDTO.getProductAttributeValueList(),product.getId(), productAttributeValueService);

        }
        return result;
    }

    /**
     * 编辑数据初始化
     * @param id
     * @return
     */
    @Override
    public ProductUpdateInitDTO getUpdateInfo(Long id) {
        return productMapper.getUpdateInfo(id);
    }

    /**
     * 修改保存
     * @param productSaveParamsDTO
     * @return
     */
    @Override
    @Transactional
    public boolean update(ProductSaveParamsDTO productSaveParamsDTO) {
        // 1. 保存商品基本信息 --商品主表
        PmsProduct product=productSaveParamsDTO;
        boolean result = this.updateById(product);
        if(result) {

            // 为了解决 前端会传入其他促销方式的空数据进来
            switch (product.getPromotionType()) {
                case 2:
                    // 2. 会员价格

                    // 根据商品id删除
                    DeleteManyListByProductId(product.getId(),memberPriceService);
                    SaveManyList(productSaveParamsDTO.getMemberPriceList(), product.getId(), memberPriceService);
                    break;
                case 3:
                    // 根据商品id删除
                    DeleteManyListByProductId(product.getId(),productLadderService);
                    // 3. 阶梯价格
                    SaveManyList(productSaveParamsDTO.getProductLadderList(), product.getId(), productLadderService);
                    break;
                case 4:
                    // 根据商品id删除
                    DeleteManyListByProductId(product.getId(),productFullReductionService);
                    // 4. 减满价格
                    SaveManyList(productSaveParamsDTO.getProductFullReductionList(), product.getId(), productFullReductionService);
                    break;
            }
            // 根据商品id删除
            DeleteManyListByProductId(product.getId(),skuStockService);
            // 5. sku
            SaveManyList(productSaveParamsDTO.getSkuStockList(),product.getId(), skuStockService);

            // 根据商品id删除
            DeleteManyListByProductId(product.getId(),productAttributeValueService);
            // 6 spu
            SaveManyList(productSaveParamsDTO.getProductAttributeValueList(),product.getId(), productAttributeValueService);

        }
        return result;
    }

    /**
     * 根据商品id删除关联数据
     */
    public void DeleteManyListByProductId(Long productId, IService service){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id",productId);

        service.remove(queryWrapper);
    }


    /**
     *  公共方法： 保存会员价格、阶梯价格、减满价格、 sku 、 spu 商品的关联数据
     *
     *  统一： 都需要设置商品id,  都需要批量保存
     */
    public void SaveManyList(List list, Long productId, IService service){
        // 如果数据为空 或者长度为0  不做任何操作
        if(CollectionUtil.isEmpty(list)) return;

        try {
            // 循环 反射 赋值商品id
            for (Object obj : list) {
                Method setProductIdMethod = obj.getClass().getMethod("setProductId", Long.class);

                // 在修改状态清除主键id
                Method setId = obj.getClass().getMethod("setId", Long.class);
                setId.invoke(obj,(Long)null);

                // 调用setProductId
                setProductIdMethod.invoke(obj, productId);
            }

            service.saveBatch(list);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}

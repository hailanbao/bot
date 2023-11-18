package com.tianbo.mall.modules.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.common.api.CommonPage;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.dto.RelationAttrInfoDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttribute;
import com.tianbo.mall.modules.product.service.PmsProductAttributeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 商品属性规格参数 前端控制器
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
    //    url:'/productAttribute/list/'+cid,
//    method:'get',
//    params:params
    @Autowired
    PmsProductAttributeService pmsProductAttributeService;

    @ApiOperation("商品分类属性列表")
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
                                                                 @RequestParam(value = "type") Integer type,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = pmsProductAttributeService.list(cid, type, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    //    url:'/productAttribute/create',
//    method:'post',
//    data:data
    @ApiOperation("添加商品属性")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductAttribute pmsProductAttribute) {
        boolean result = pmsProductAttributeService.create(pmsProductAttribute);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productAttribute/'+id,
//    method:'get'
    @ApiOperation("通过Id获取商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductAttribute> getById(@PathVariable Long id) {
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeService.getById(id);
        return CommonResult.success(pmsProductAttribute);
    }

    //    url:'/productAttribute/update/'+id,
//    method:'post',
//    data:data
    @ApiOperation("编辑商品属性")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductAttribute pmsProductAttribute) {
        boolean result = pmsProductAttributeService.updateById(pmsProductAttribute);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productAttribute/delete',
//    method:'post',
//    data:data
    @ApiOperation("删除商品类型")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam("ids") List<Long> id) {
        boolean result = pmsProductAttributeService.delete(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productAttribute/attrInfo/'+productCategoryId,
//    method:'get'
    @ApiOperation("根据商品分类id获取关联的筛选属性")
    @RequestMapping(value = "/attrInfo/{cId}")
    public CommonResult getRelationAttrInfoByCid(@PathVariable Long cId) {
        List<RelationAttrInfoDTO> list = pmsProductAttributeService.getRelationAttrInfoByCid(cId);
        return CommonResult.success(list);
    }

}


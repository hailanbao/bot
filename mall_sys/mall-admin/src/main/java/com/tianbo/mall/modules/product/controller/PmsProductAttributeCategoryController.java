package com.tianbo.mall.modules.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.common.api.CommonPage;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.dto.ProductAttributeCateDTO;
import com.tianbo.mall.modules.product.model.PmsProductAttributeCategory;
import com.tianbo.mall.modules.product.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品类型 前端控制器
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@RestController
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
    //    url:'/productAttribute/category/list',
//    method:'get',
//    params:params
    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation("商品类型数据列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = pmsProductAttributeCategoryService.list(pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    //    url:'/productAttribute/category/create',
//    method:'post',
//    data:data
    @ApiOperation("添加商品类型")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(PmsProductAttributeCategory pmsProductAttributeCategory) {
        boolean result = pmsProductAttributeCategoryService.add(pmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productAttribute/category/update/'+id,
//    method:'post',
//    data:data
    @ApiOperation("编辑商品类型")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(PmsProductAttributeCategory pmsProductAttributeCategory) {
        boolean result = pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productAttribute/category/delete/'+id,
//    method:'get'
    @ApiOperation("删除商品类型")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult delete(PmsProductAttributeCategory pmsProductAttributeCategory) {
        boolean result = pmsProductAttributeCategoryService.removeById(pmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }
//
//    url:'/productAttribute/category/list/withAttr',
//    method:'get'
    @ApiOperation("获取商品属性下拉级联数据")
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    public CommonResult listAttr() {
        List<ProductAttributeCateDTO> list = pmsProductAttributeCategoryService.getListAttr();
        return CommonResult.success(list);
    }

}


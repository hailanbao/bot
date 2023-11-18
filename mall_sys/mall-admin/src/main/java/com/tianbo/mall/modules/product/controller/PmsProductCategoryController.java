package com.tianbo.mall.modules.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.common.api.CommonPage;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.dto.PmsProductCategoryDTO;
import com.tianbo.mall.dto.ProductCateChildrenDTO;
import com.tianbo.mall.modules.product.model.PmsProductCategory;
import com.tianbo.mall.modules.product.service.PmsProductCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品分类 前端控制器
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
    //    export function fetchList(params) {
//        return request({
//                url:'/product/list',
//                method:'get',
//                params:params
//  })
//    }
    @Autowired
    PmsProductCategoryService pmsProductCategoryService;

    @ApiOperation("商品分类数据列表")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = pmsProductCategoryService.list(parentId, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    //    url:'/productCategory/update/navStatus',
//    method:'post',
//    data:data
    @ApiOperation("状态改变")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public CommonResult updateNavStatus(@RequestParam(value = "ids") List<Long> ids,
                                        @RequestParam(value = "navStatus") Integer navStatus) {
        boolean result = pmsProductCategoryService.updateNavStatus(ids, navStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productCategory/update/showStatus',
//    method:'post',
//    data:data
    @ApiOperation("是否显示")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam(value = "ids") List<Long> ids,
                                         @RequestParam(value = "showStatus") Integer showStatus) {
        boolean result = pmsProductCategoryService.updateShowStatus(ids, showStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //      return request({
//        url:'/productCategory/delete/'+id,
//                method:'post'
//    商品分类删除
    @ApiOperation("商品分类删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult deleteById(@PathVariable Long id) {
        boolean result = pmsProductCategoryService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productCategory/create',
//    method:'post',
//    data:data
    @ApiOperation("添加商品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductCategoryDTO pmsProductCategoryDTO) {
        boolean result = pmsProductCategoryService.saveCustom(pmsProductCategoryDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    //    url:'/productCategory/'+id,
//    method:'get',
    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductCategory> getById(@PathVariable Long id) {
        PmsProductCategory ProductCategory = pmsProductCategoryService.getById(id);
        return CommonResult.success(ProductCategory);
    }

    //    url:'/productCategory/update/'+id,
    //    method:'post',
    //    data:data

    @ApiOperation("编辑更新商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update( @RequestBody PmsProductCategoryDTO productCategoryDTO) {

        boolean result = pmsProductCategoryService.update(productCategoryDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

//    url:'/productCategory/list/withChildren',
//    method:'get'
    @ApiOperation("获取商品分类子级")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    public CommonResult getListWithChildren() {
        List<ProductCateChildrenDTO> list = pmsProductCategoryService.getListWithChildren();
        return CommonResult.success(list);
    }

}


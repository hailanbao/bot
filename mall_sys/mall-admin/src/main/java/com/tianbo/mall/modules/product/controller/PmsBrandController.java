package com.tianbo.mall.modules.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.common.api.CommonPage;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.dto.PmsProductCategoryDTO;
import com.tianbo.mall.modules.product.model.PmsBrand;
import com.tianbo.mall.modules.product.model.PmsProductCategory;
import com.tianbo.mall.modules.product.service.PmsBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    PmsBrandService brandService;

    /**
     * 品牌数据列表
     * 在商品中进行共用
     * url:'/brand/list',
     * method:'get',
     * params:params
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = brandService.list(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    //    url:'/brand/create',
//    method:'post',
//    data:data
    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsBrand pmsBrand) {
        boolean result = brandService.save(pmsBrand);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

//    url:'/brand/'+id,
//    method:'get',
    @ApiOperation("根据id获取品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> getById(@PathVariable Long id) {
        PmsBrand pmsBrand = brandService.getById(id);
        return CommonResult.success(pmsBrand);
    }

//    url:'/brand/update/'+id,
//    method:'post',
//    data:data
    @ApiOperation("编辑更新品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update( @RequestBody PmsBrand pmsBrand) {

        boolean result = brandService.update(pmsBrand);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

//    url:'/brand/delete/'+id,
//    method:'get',
    @ApiOperation("商品分类删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult deleteById(@PathVariable Long id) {
        boolean result = brandService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

//    url:'/brand/update/showStatus',
//    method:'post',
//    data:data
    @ApiOperation("是否显示")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam(value = "ids") List<Long> ids,
                                         @RequestParam(value = "showStatus") Integer showStatus) {
        boolean result = brandService.updateShowStatus(ids, showStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

//    url:'/brand/update/factoryStatus',
//    method:'post',
//    data:data
    @ApiOperation("品牌制造商")
    @RequestMapping(value = "/update/factoryStatus",method = RequestMethod.POST)
    public CommonResult updateFactoryStatus(@RequestParam(value = "ids") List<Long> ids,
                                         @RequestParam(value = "factoryStatus") Integer factoryStatus) {
        boolean result = brandService.updateFactoryStatus(ids, factoryStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }


}


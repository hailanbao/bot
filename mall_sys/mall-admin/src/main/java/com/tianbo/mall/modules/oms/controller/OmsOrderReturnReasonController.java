package com.tianbo.mall.modules.oms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.common.api.CommonPage;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.modules.oms.model.OmsOrder;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnReason;
import com.tianbo.mall.modules.oms.service.OmsOrderReturnReasonService;
import com.tianbo.mall.modules.product.model.PmsProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 退货原因表 前端控制器
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
@Controller
@Api(tags = "OmsOrderReturnReasonController", description = "退货原因管理")
@RequestMapping("/returnReason")
public class OmsOrderReturnReasonController {
    @Autowired
    private OmsOrderReturnReasonService orderReturnReasonService;

    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody OmsOrderReturnReason returnReason) {
        int count = orderReturnReasonService.create(returnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改退货原因")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody OmsOrderReturnReason returnReason) {
        int count = orderReturnReasonService.update(id, returnReason);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

//    @ApiOperation("批量删除退货原因")
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
//        int count = orderReturnReasonService.delete(ids);
//        if (count > 0) {
//            return CommonResult.success(count);
//        }
//        return CommonResult.failed();
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        boolean result = orderReturnReasonService.removeByIds(ids);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = orderReturnReasonService.list(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("获取单个退货原因详情信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderReturnReason> getItem(@PathVariable Long id) {
        OmsOrderReturnReason reason = orderReturnReasonService.getItem(id);
        return CommonResult.success(reason);
    }

    @ApiOperation("修改退货原因启用状态")
    @RequestMapping(value="/update/status",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("status") Integer status) {
        boolean result= orderReturnReasonService.updateStatus(status,ids, OmsOrderReturnReason::getStatus);
        if(result){
            return CommonResult.success(result);
        }
        else {
            return CommonResult.failed();
        }
    }
}


package com.tianbo.mall.controller;

import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.modules.oms.service.OmsCartItemService;
import com.tianbo.mall.dto.HomeGoodsSaleDTO;
import com.tianbo.mall.dto.HomeMenusBannerDTO;
import com.tianbo.mall.dto.HomeMenusDTO;
import com.tianbo.mall.modules.pms.service.PmsProductCategoryService;
import com.tianbo.mall.modules.sms.model.SmsHomeAdvertise;
import com.tianbo.mall.modules.sms.service.SmsHomeAdvertiseService;
import com.tianbo.mall.modules.sms.service.SmsHomeCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * 首页控制器
 */
@RestController
@Api(tags = "HomeController",description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    OmsCartItemService cartItemService;
    @Autowired
    PmsProductCategoryService productCategoryService;
    @Autowired
    SmsHomeAdvertiseService homeAdvertiseService;
    @Autowired
    SmsHomeCategoryService homeCategoryService;

    /**
     * 获取首页类型导航栏和数据
     * get("/home/menus")
     */
    @RequestMapping(value = "/menus_banner",method = RequestMethod.GET)
    public CommonResult getMenus(){
        // 分类导航
        List<HomeMenusDTO> list= productCategoryService.getMenus();

        // banner
        List<SmsHomeAdvertise> homeAdvertisesList= homeAdvertiseService.getHomeBanners();

        HomeMenusBannerDTO homeMenusBannerDTO=new HomeMenusBannerDTO();
        homeMenusBannerDTO.setHomeMenusList(list);
        homeMenusBannerDTO.setHomeAdvertisesList(homeAdvertisesList);


        return CommonResult.success(homeMenusBannerDTO);
    }

    /**
     * goods_sale
     */
    @RequestMapping(value = "/goods_sale",method = RequestMethod.GET)
    public CommonResult getGoodsSale(){
        List<HomeGoodsSaleDTO> list= homeCategoryService.getGoodsSale();
        return CommonResult.success(list);
    }

}

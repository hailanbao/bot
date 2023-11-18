package com.tianbo.mall.modules.ums.controller;


import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.modules.ums.service.UmsMemberLevelService;
import com.tianbo.mall.modules.ums.model.UmsMemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 会员等级表 前端控制器
 * </p>
 *
 * @author 田波
 * @since 2023-010-09
 */
@RestController
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {

    @Autowired
    UmsMemberLevelService memberLevelService;

    /**
     *   url:'/memberLevel/list',
     *     method:'get',
     *     params:{defaultStatus: 0}
     */
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value="defaultStatus",defaultValue = "0") Integer defaultStatus)
    {
        List<UmsMemberLevel> list= memberLevelService.list(defaultStatus);
        return CommonResult.success(list);
    }
}


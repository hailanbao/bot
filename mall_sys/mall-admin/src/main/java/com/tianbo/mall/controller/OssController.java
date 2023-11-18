package com.tianbo.mall.controller;
import com.tianbo.mall.dto.OssPolicyResult;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping(value = "/aliyun/oss",method = RequestMethod.GET)
public class OssController {
    @Autowired
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

}

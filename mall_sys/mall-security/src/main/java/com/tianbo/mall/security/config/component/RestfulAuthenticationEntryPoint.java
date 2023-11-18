package com.tianbo.mall.security.config.component;

import cn.hutool.json.JSONUtil;
import com.tianbo.mall.common.api.CommonResult;
import com.tianbo.mall.common.api.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *  没有登录时的响应
 */
public class RestfulAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        // 响应401 暂未登录或session已经过期
        response.getWriter().println(JSONUtil.parse(CommonResult.failed(ResultCode.UNAUTHORIZED)));
        response.getWriter().flush();
    }
}

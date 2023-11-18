package com.tianbo.mall.config;

import com.tianbo.mall.common.config.BaseSwaggerConfig;
import com.tianbo.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.tianbo.mall.modules")
                .title("商城项目前台")
                .description("mall项目前台接口文档")
                .contactName("tianbo")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}

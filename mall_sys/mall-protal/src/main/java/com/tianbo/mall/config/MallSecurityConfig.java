package com.tianbo.mall.config;

import com.tianbo.mall.modules.ums.service.UmsMemberService;
import com.tianbo.mall.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity  // 启动
public class MallSecurityConfig extends SecurityConfig {

    @Autowired
    private UmsMemberService memberService;

    /**
     * 认证交给springsecurity
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> memberService.loadUserByUsername(username);
    }

}

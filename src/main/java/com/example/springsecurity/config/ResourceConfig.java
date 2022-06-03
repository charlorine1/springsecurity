package com.example.springsecurity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @title: ResourceConfig
 * @projectName springsecurity
 * @description: TODO
 * @date 2022/6/223:32
 */
@Component
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                // 所有的请求都要认证
                .authenticated().and()
                .requestMatchers().antMatchers("/user/**");
    }
}

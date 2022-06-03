package com.example.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @title: AuthorizationServerConfig
 * @projectName springsecurity
 * @description: 认证服务器
 * @date 2022/6/223:26
 */
@Component
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //可户端 凭证，多个客户登录授权服务器，不同的用户有不同的范围
        clients.inMemory().withClient("ZHUJIERU")
                .secret(passwordEncoder.encode("222222"))
                .redirectUris("http://www.baidu.com")
                .scopes("all")
                // 授权码模式
                .authorizedGrantTypes("authorization_code");
    }
}

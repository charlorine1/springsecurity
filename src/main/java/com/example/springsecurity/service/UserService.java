package com.example.springsecurity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author yang
 * @title: UserService
 * @projectName springsecurity
 * @description: TODO
 * @date 2022/6/218:43
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户登录，用户名{}", username);

        //使用service 查询数据库获取用户名和密码
        String password = "1";

        return new User(username, passwordEncoder.encode(password), AuthorityUtils.createAuthorityList("ROLE_VIP1", "ROLE_VIP2"));

    }
}

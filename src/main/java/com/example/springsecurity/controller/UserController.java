package com.example.springsecurity.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @title: UserController
 * @projectName springsecurity
 * @description: 资源、认证通过后可以通过该接口获取资源
 * @date 2022/6/2   23:16
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getUser")
    public String getUserDetail(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return user.toString();
    }


}

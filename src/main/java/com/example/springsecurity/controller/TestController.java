package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @title: TestController
 * @projectName springsecurity
 * @description: TODO
 * @date 2022/6/218:41
 */
@RestController
public class TestController {


    @PreAuthorize("hasAnyRole('VIP3')")
    @RequestMapping("/testVIP3")
    public String getTest(){
        return  "success--VIP3";
    }


    @PreAuthorize("hasRole('VIP2')")
    @RequestMapping("/testVIP2")
    public String getTest1(){
        return  "success--VIP2";
    }

}

package com.jiangxia.demo02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年05月06日 14:11
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }
}

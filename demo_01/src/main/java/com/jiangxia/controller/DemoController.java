package com.jiangxia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangxia
 * @date 2022年05月05日 16:25
 * desc:controller ： 浏览器输入：http://localhost:8081/demo1/demo/demo
 **/

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("demo")
    // 将控制器的返回值转为jason格式的字符串，并响应浏览器
    // 可以使用restcontroller
    @ResponseBody
    public String demo(){
        System.out.println("demo ok");
        return "demo ok";
    }

    /**
     * @author:江夏
     * @date 2022/5/5 16:29
     * @version 1.0
     * @description: 集成jsp： 1、插件启动 2、 configurations-environment-working-directory-选择$MODULE_WORKING_DIR$（最后一个）
     */
    @RequestMapping("index")
    public String index(){
        System.out.println("index ok");
        return "index";
    }
}

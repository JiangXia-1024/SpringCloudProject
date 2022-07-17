package com.jiangxia.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年07月03日 21:03
 */
@RestController
public class DemoController {

    /**
     * @author:江夏
     * @date 2022/7/3 21:34
     * @version 1.0
     * @description: 如果某个时间段内(10s内）20次请求失败或者请求失败比例超过50%,则熔断器打开，5s之后如果请求正确则正确请求，如果还是错误请求，则熔断器继续
     */
    @GetMapping("/demo")//?id=
    //自定义的处理方法
    //   @HystrixCommand(fallbackMethod = "demoFallbackMethod")//熔断之后的处理,fallbackMethod表示失败之后的方法名，即失败之后调用该方法
    @HystrixCommand(defaultFallback = "defaultFallBackMethod") //熔断之后默认的处理方法
    public String demo(Integer id){
        System.out.println("demo ok!");
        if(id<0){
            throw new RuntimeException("id无效！");
        }
        return "demo ok";
    }

    @GetMapping("/demo01")//?id=
    //自定义的处理方法
    //   @HystrixCommand(fallbackMethod = "demoFallbackMethod")//熔断之后的处理,fallbackMethod表示失败之后的方法名，即失败之后调用该方法
    @HystrixCommand(defaultFallback = "defaultFallBackMethod") //熔断之后默认的处理方法
    public String demo01(Integer id){
        System.out.println("demo ok!");
        if(id<0){
            throw new RuntimeException("id无效！");
        }
        return "demo ok";
    }

    /**
     * @author:江夏
     * @date 2022/7/3 21:49
     * @version 1.0
     * @description: 自定义熔断处理方法
     */
    public String demoFallbackMethod(Integer id){
        return "当前系统繁忙，请稍后再试！！！";
    }

    /**
     * @author:江夏
     * @date 2022/7/3 21:52
     * @version 1.0
     * @description: 默认的熔断之后的处理方法
     */
    public String defaultFallBackMethod(){
        return "当前系统繁忙，请稍后再试(默认)！！！";
    }
}

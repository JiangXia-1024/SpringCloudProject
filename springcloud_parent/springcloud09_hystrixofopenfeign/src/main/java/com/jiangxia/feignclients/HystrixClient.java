package com.jiangxia.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jiangxia
 * @date 2022年07月09日 18:09
 */
@FeignClient(value="hystrix",fallback = HystrixClientFallBack.class)//调用hystrix服务,fallback属性表示当调用的服务不可用时，默认的备选处理方式
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam("id") Integer id);
}

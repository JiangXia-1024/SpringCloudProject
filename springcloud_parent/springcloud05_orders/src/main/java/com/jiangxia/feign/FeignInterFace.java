package com.jiangxia.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "ORDER")
public interface FeignInterFace {
}

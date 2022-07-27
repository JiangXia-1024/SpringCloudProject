package com.jiangxia.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author jiangxia
 * @date 2022年07月27日 21:02
 * 自定义网关全局filter
 */
@Configuration
public class CustomizeGlobalFilter implements GlobalFilter, Ordered {

    //类似于javaweb的dofilter方法
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过了全局filter处理");
        Mono<Void> filter = chain.filter(exchange);//放行filter继续向后执行
        System.out.println("响应回来filter处理");
        return filter;
    }


    //排序：默认顺序按照自然顺序排序，-1则表示在所有的filter执行之前执行，即先执行自定的再执行配置文件设置的filter
    @Override
    public int getOrder() {
        return -1;
    }
}

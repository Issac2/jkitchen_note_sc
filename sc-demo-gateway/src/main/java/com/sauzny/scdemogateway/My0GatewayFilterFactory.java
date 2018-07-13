package com.sauzny.scdemogateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// 类名一定要为filterName + GatewayFilterFactory，如这里定义为My0GatewayFilterFactory的话，它的filterName就是My0
// 配置文件中写My0
// 这是一个无参数，无值的filter
// 按照 org.springframework.cloud.gateway.filter.factory.PreserveHostHeaderGatewayFilterFactory
@Component
@Slf4j
public class My0GatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            // 使用 exchange 进行自己需要的操作
            log.info("我是一个自定义的无参数，无值的filter，我是My0GatewayFilterFactory");
            return chain.filter(exchange);
        };
    }
}

package com.sauzny.scdemogateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// 不需要额外配置就可以生效
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    // 数值越小，优先级越高
    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("我是一个全局过滤器，我的名字是MyGlobalFilter");
        // exchange，理解为上下文吧，可以对当前的请求做出一些修改
        //exchange.getRequest();
        //exchange.getResponse();
        return chain.filter(exchange);
    }

}

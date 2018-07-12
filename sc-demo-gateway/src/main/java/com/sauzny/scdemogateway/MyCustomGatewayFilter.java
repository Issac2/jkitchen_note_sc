package com.sauzny.scdemogateway;

import java.nio.charset.StandardCharsets;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// 这种方式的 filter 看其他demo都是使用在代码router中，我使用在MyRoute.customRouteLocator()中
// 使用GatewayFilterFactory方式，将自定义filter使用在配置文件中
@Slf4j
public class MyCustomGatewayFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        
        String guo = exchange.getRequest().getQueryParams().getFirst("scgtest");
        
        log.info("this is MyCustomGatewayFilter, guo = {}", guo);
        
        if ("guo".equals(guo)) {
            return chain.filter(exchange);
        }
        
        exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
        DataBuffer bodyDataBuffer = exchange.getResponse().bufferFactory().wrap(("{\"guo\":"+guo+"}").getBytes(StandardCharsets.UTF_8));
        
        //return exchange.getResponse().setComplete();
        
        return exchange.getResponse().writeWith(Mono.just(bodyDataBuffer));
    }

}

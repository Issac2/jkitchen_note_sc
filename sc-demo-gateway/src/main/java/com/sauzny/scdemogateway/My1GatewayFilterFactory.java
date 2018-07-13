package com.sauzny.scdemogateway;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//类名一定要为filterName + GatewayFilterFactory，如这里定义为My1GatewayFilterFactory的话，它的filterName就是My1
//配置文件中写My1
//这是一个无参数，有值的filter
//按照 org.springframework.cloud.gateway.filter.factory.RemoveRequestHeaderGatewayFilterFactory
@Component
@Slf4j
public class My1GatewayFilterFactory extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    public My1GatewayFilterFactory() {
        super(NameConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return (exchange, chain) -> {
            
            // 使用 exchange 进行自己需要的操作
            log.info("我是一个自定义的无参数，有值的filter，我是My1GatewayFilterFactory，传入的值是{}", config.getName());

            return chain.filter(exchange);
        };
    }
}

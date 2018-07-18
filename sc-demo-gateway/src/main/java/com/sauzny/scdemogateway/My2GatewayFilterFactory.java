package com.sauzny.scdemogateway;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//类名一定要为filterName + GatewayFilterFactory，如这里定义为My2GatewayFilterFactory的话，它的filterName就是My2
//配置文件中写My2
//这是一个有参数，无值的filter
//按照 org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory
@Component
@Slf4j
public class My2GatewayFilterFactory extends AbstractGatewayFilterFactory<My2GatewayFilterFactory.My2Config> {

    public My2GatewayFilterFactory() {
        super(My2Config.class);
    }
    
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME_KEY);
    }
    
    @Data
    public static class My2Config {
        private String name;
        private URI uri;
        private List<URI> uris;
    }


    @Override
    public GatewayFilter apply(My2Config my2) {

        return (exchange, chain) -> {
            // 使用 exchange 进行自己需要的操作
            log.info("I'm a filter,has args and no value,my name is My2GatewayFilterFactory,all args,name={}, uri={}, uris={}", my2.getName(), my2.getUri(), my2.getUris());
            return chain.filter(exchange);
        };
    }

    
}


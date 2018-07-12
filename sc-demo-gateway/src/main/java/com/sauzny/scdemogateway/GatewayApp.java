package com.sauzny.scdemogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
//导入kotlin编写的类
//@Import(AdditionalRoutes.class)
public class GatewayApp {
    
    // 服务发现组件
    // 与服务注册于发现组件进行结合，通过serviceId转发到具体的服务实例。在前面的配置已经引入了相应的依赖。
    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class);
    }
}

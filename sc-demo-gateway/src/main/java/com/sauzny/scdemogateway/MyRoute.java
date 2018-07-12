package com.sauzny.scdemogateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MyRoute {

    // 路由断言工厂
    // 路由断言工厂有多种类型，根据请求的时间、host、路径、方法等等。如下定义的是一个基于路径的路由断言匹配。
    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction() {
        
        // 当请求的路径为/testfun时，直接返回ok的状态码，且响应体为hello字符串。
        
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/testfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
        return route;
    }
    
    @Bean
    public RouterFunction<ServerResponse> faviconicoRouterFunction() {
        
        // 当请求的路径为/testfun时，直接返回ok的状态码，且响应体为hello字符串。
        
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                RequestPredicates.path("/favicon.ico"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
        return route;
    }

    // 过滤器工厂
    // 网关经常需要对路由请求进行过滤，进行一些操作，
    // 如鉴权之后构造头部之类的，
    // 过滤的种类很多，如增加请求头、增加请求参数、增加响应头和断路器等等功能。
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        
        // 当请求路径为/image/webp时，将请求转发到http://httpbin.org:80，并对响应进行过滤处理，增加响应的头部X-AnotherHeader: baz。
        
        return builder.routes()
                .route(r -> r.path("/image/webp")
                        .filters(f -> f.addResponseHeader("X-AnotherHeader", "baz"))
                        .uri("http://httpbin.org:80")
                )
                .build();
        
    }

    // 使用kotlin自定义路由
    /*
    @Bean
    fun additionalRouteLocator(builder: RouteLocatorBuilder): RouteLocator = builder.routes {
        route(id = "test-kotlin") {
            path("/image/png")
            filters {
                addResponseHeader("X-TestHeader", "foobar")
            }
            uri("http://httpbin.org:80")
        }
    }
    */
}

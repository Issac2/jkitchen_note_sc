# spring cloud gateway

`org.springframework.cloud.gateway.config.GatewayProperties`

根据这个类的结构去了解 spring cloud gateway

官方文档：

https://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html#_spring_cloud_gateway

## 一、介绍说明

### 1. 基本组件属性

- route，路由
	- id，唯一标识
    - uri，转发目的地址，要跳转到哪
    - order，顺序，数字越小越先使用
    - predicates，断言器（这翻译），就是判断匹配的作用，数组，可配置多个
    - filters，过滤器，数组，可配置多个

### 2. gateway 提供的断言器 predicates

- Path=/**
- RemoteAddr=192.168.1.1/24
- Query=baz
- Method=GET
- Host=**.somehost.org
- Header=X-Request-Id, \d+
- Cookie=chocolate, ch.p
- After=2017-01-20T17:42:47.789-07:00[America/Denver]
- Before=2017-01-20T17:42:47.789-07:00[America/Denver]
- Between=2017-01-20T17:42:47.789-07:00[America/Denver], 2017-01-21T17:42:47.789-07:00[America/Denver]

### 3. gateway 提供的过滤器 filters

Spring Cloud Gateway提供了很多种类的过滤器工厂，网关过滤器有近二十个实现类

总得说来可以分为七类：Header、Parameter、Path、Status、Redirect跳转、Hystrix熔断和RateLimiter限流等。

- AddRequestHeader=X-Request-Foo, Bar
- AddRequestParameter=foo, bar
- AddResponseHeader=X-Response-Foo, Bar
- Hystrix=myCommandName
- PrefixPath=/mypath
- PreserveHostHeader
- RequestRateLimiter
- RedirectTo=302, http://acme.org
- RemoveRequestHeader=X-Request-Foo
- RemoveResponseHeader=X-Response-Foo
- RewritePath=/foo/(?<segment>.*), /$\{segment}
- SaveSession
- SetPath=/{segment}
- SetResponseHeader=X-Response-Foo, Bar
- SetStatus=401
- StripPrefix=2
- Retry

`spring.cloud.gateway.filter.remove-non-proxy-headers.headers` 将会移除一些header
```
Connection
Keep-Alive
Proxy-Authenticate
Proxy-Authorization
TE
Trailer
Transfer-Encoding
Upgrade
```

`spring.cloud.gateway.filter.secure-headers` 将会改变一些header的值，这个不是很理解

```
X-Xss-Protection:1; mode=block
Strict-Transport-Security:max-age=631138519
X-Frame-Options:DENY
X-Content-Type-Options:nosniff
Referrer-Policy:no-referrer
Content-Security-Policy:default-src 'self' https:; font-src 'self' https: data:; img-src 'self' https: data:; object-src 'none'; script-src https:; style-src 'self' https: 'unsafe-inline'
X-Download-Options:noopen
X-Permitted-Cross-Domain-Policies:none
```

### 二、自定义组件与使用

#### 自定义filter

参考源码的写法，`org.springframework.cloud.gateway.filter.factory`，编写demo

- My0GatewayFilterFactory，无参数，无值
- My1GatewayFilterFactory，无参数，有值
- My2GatewayFilterFactory，有参数，无值
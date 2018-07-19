# sleuth

sleuth + zipkin

#### zipkin-server部署

[zipkin-server文档](zipkin-server.md)

#### 业务服务端

参考项目 `sc-demo-consumer` `sc-demo-provider`

pom中引入组件

```
spring-cloud-starter-sleuth
spring-cloud-starter-zipkin
spring-cloud-stream-binder-rabbit
```

#### web页面效果

http://192.168.73.203:9411/

![](sleuth01.png)
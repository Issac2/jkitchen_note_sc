# jkitchen_note_sc

spring cloud demo

版本：Finchley.RELEASE

consul服务注册图：

![sc01](md/sc01.png)

业务API数据流程图：

![sc02](md/sc02.png)

组件：

- consul 注册中心 [文档](sc-demo-provider/md/consulKeyValue.md)
- consul 配置中心 [文档](sc-demo-provider/md/consulKeyValue.md)
- gateway 网关 [文档](sc-demo-gateway/README.md)
- hystrix dashboard 熔断器仪表盘 [文档](sc-demo-hystrixdashboard/README.md)
- turbine 集群信息收集 [文档](sc-demo-turbine/README.md)
- Sleuth+Zipkin 分布式链路跟踪 [文档](sc-demo-consumer/md/zipkin-server.md)
- feign+ribbon 通信+客户端负载均衡

demo服务端口号占用：

| 服务名 | 端口号 |
|--------|--------|
| sc-demo-provider | 8080 |
| sc-demo-consumer | 18080 |
| sc-demo-gateway | 28080 |
| sc-demo-turbine | 48080 |
| sc-demo-hystrixdashboard | 58080 |

web地址访问：

| web服务 | 访问地址 | 类型 |
|--------|--------|--------|
| consul | http://192.168.73.201:8500 | web ui |
| rabbitmq | http://192.168.73.1:15672 | web ui |
| hystrixdashboard | http://192.168.73.1:58080/hystrix | web ui |
| zipkin | http://192.168.73.203:9411 | web ui |
| turbine | http://192.168.73.1:48080/turbine.stream | api |
| gateway | http://192.168.73.1:28080/ | api |

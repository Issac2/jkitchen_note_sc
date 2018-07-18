# jkitchen_note_sc

spring cloud demo

版本：Finchley.RELEASE

组件：

- consul 注册中心 [文档](sc-demo-provider/md/consulKeyValue.md)
- consul 配置中心 [文档](sc-demo-provider/md/consulKeyValue.md)
- gateway 网关 [文档](sc-demo-gateway/README.md)
- hystrix dashboard 熔断器仪表盘 [文档](sc-demo-hystrixdashboard/README.md)
- turbine 集群信息收集 [文档](sc-demo-turbine/README.md)
- feign+ribbon 通信+客户端负载均衡
- Sleuth+Zipkin 分布式链路跟踪

demo服务端口号占用：

| 服务名 | 端口号 |
|--------|--------|
| sc-demo-provider | 8080 |
| sc-demo-consumer | 18080 |
| sc-demo-gateway | 28080 |
| sc-demo-turbine | 48080 |
| sc-demo-hystrixdashboard | 58080 |

web地址访问：

| web服务 | 访问地址 |
|--------|--------|
| consul | http://192.168.73.201:8500 |
| rabbitmq | http://192.168.73.1:15672 |
| hystrixdashboard | http://192.168.73.1:58080/hystrix |
| turbine | http://192.168.73.1:48080/turbine.stream |
| gateway | http://192.168.73.1:28080/ |

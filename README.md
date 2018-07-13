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

demo服务端口号占用：

| 服务名 | 端口号 |
|--------|--------|
| sc-demo-provider | 8080 |
| sc-demo-consumer | 18080 |
| sc-demo-gateway | 28080 |
| sc-demo-turbine | 48080 |
| sc-demo-hystrixdashboard | 58080 |
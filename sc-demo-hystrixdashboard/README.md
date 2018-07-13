# dashboard

访问地址：http://localhost:58080/hystrix/

##### 一、集群监控

需要启动 `sc-demo-turbine`

在页面输入地址（turbine的一个接口）

http://localhost:48080/turbine.stream

然后访问 consumer 的业务接口，就能在监控中看到效果

##### 二、单机器监控

在页面输入地址（consumer的一个接口）

http://localhost:18080/actuator/hystrix.stream

然后访问 consumer 的业务接口，就能在监控中看到效果

##### 三、 仪表盘说明

![dashboard01](md/dashboard02.png)
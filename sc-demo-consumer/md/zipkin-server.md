# zipkin-serve

## 一、基本安装部署启动

官网地址：https://zipkin.io/pages/quickstart.html
github地址：https://github.com/openzipkin/zipkin

##### java方式安装部署

```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```

##### 访问

http://localhost:9411


## 二、其他说明：

##### 配置参数说明：

`https://github.com/openzipkin/zipkin/blob/master/zipkin-server/src/main/resources/zipkin-server-shared.yml`

配合rabbitmq启动命令 `RABBIT_ADDRESSES=192.168.73.1:5673 RABBIT_VIRTUAL_HOST=testmqhost RABBIT_USER=testmqun RABBIT_PASSWORD=testmqpw STORAGE_TYPE=mysql MYSQL_HOST=192.168.73.1 MYSQL_USER=root MYSQL_PASS=root java -jar zipkin.jar`

在windows上源码打包：

`./mvnw -DskipTests --also-make -pl zipkin-server clean install`

在windows上打包后启动：

`RABBIT_ADDRESSES=localhost:5673 STORAGE_TYPE=mysql MYSQL_USER=root MYSQL_PASS=root java -jar ./zipkin-server/target/zipkin-server-*exec.jar`

##### 存储方式说明：

- 内存，一般测试使用
- cassandra，note：需要spark job
- elasticsearch，note：需要spark job
- mysql

我这里使用的是mysql


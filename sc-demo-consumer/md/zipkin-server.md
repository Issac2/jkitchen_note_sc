# zipkin-server

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

##### 存储方式说明：

- 内存，一般测试使用
- cassandra，note：需要spark job
- elasticsearch，note：需要spark job
- mysql

我这里使用的是mysql，mysql需要自己手动执行[建表脚本](sc-demo-consumer/md/zipkin-mysql.sql)

我把脚本做了修改，原来脚本中的编码是utf8，我修改为utf8mb4

原脚本位置 `zipkin\zipkin-storage\mysql-v1\src\main\resources\mysql.sql`

##### 启动步骤

我启动的步骤……，不要问我为什么……

1. 在数据库中建好表

2. 在windows上源码打包：

`./mvnw -DskipTests --also-make -pl zipkin-server clean install`

3. 配合rabbitmq在ubuntu启动命令

`RABBIT_ADDRESSES=192.168.73.1:5673 RABBIT_USER=sc RABBIT_PASSWORD=sc STORAGE_TYPE=mysql MYSQL_HOST=192.168.73.1 MYSQL_USER=root MYSQL_PASS=root java -Xmx256M -Xms128M -jar zipkin-server-2.10.3-SNAPSHOT-exec.jar`




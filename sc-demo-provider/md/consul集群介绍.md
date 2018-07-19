# consul集群介绍

##### consul是分布式的、高可用、横向扩展的。

consul提供的一些关键特性：

- service discovery：consul通过DNS或者HTTP接口使服务注册和服务发现变的很容易，一些外部服务，例如saas提供的也可以一样注册。
- health checking：健康检测使consul可以快速的告警在集群中的操作。和服务发现的集成，可以防止服务转发到故障的服务上面。
- key/value storage：一个用来存储动态配置的系统。提供简单的HTTP接口，可以在任何地方操作。
- multi-datacenter：无需复杂的配置，即可支持任意数量的区域。

##### 部署效果图：

![image](https://picabstract-preview-ftn.weiyun.com:8443/ftn_pic_abs_v2/d9870c928e2dc0f7b140ee3b5a7a99a4274859fe7dcee32c82deacc5f56ce4ce53b3c4e3e43656f6e91929b95d38090a?pictype=scale&from=30113&version=3.3.3.3&uin=361376366&fname=consul-cluster-01.png&size=750)

##### 实际使用：

创建consul server实例形成集群（查看集群安装文档），

在实际部署业务服务的机器上启动一个consul client实例，

也就是说，每一个业务服务启动的时候都连接本地的consul agent。

##### consul集群部署

[consul集群安装文档](consul集群安装.md)

##### consul客户端部署

配置文件demo：

```
{
  "datacenter": "consul-cluster",
  "node_name": "consul-client-01",
  "bind_addr": "192.168.73.1",
  "client_addr": "127.0.0.1",
  "server": false,
  "bootstrap_expect": 0,
  "data_dir": "data",
  "http_config": {
    "response_headers": {
      "Access-Control-Allow-Origin": "*"
    }
  },
  "log_level": "INFO",
  "enable_syslog": false,
  "ports": {
    "http": 8500,
    "dns": 8600,
    "serf_lan": 8301,
    "serf_wan": 8302
  },
  "enable_script_checks": false
}
```

可能需要按照实际情况配置

```
  "node_name": "consul-client-01",
  "bind_addr": "0.0.0.0",
  "client_addr": "127.0.0.1",
```

命令：

```
nohup ./consul agent -config-file consul_config.json -ui &
./consul join -http-addr=127.0.0.1:8500 192.168.73.201
```

##### consul client 对本机服务的查删

使用 curl 命令

查看：

`curl -v 127.0.0.1:8500/v1/agent/services`

删除：

`curl -v -X PUT 127.0.0.1:8500/v1/agent/service/deregister/要删除的服务id`


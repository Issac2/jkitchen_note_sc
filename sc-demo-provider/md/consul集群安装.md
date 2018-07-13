# consul集群安装

##### 下载安装

https://www.consul.io/downloads.html

版本 consul_1.2.0_linux_amd64.zip

解压之后是一个可执行文件，就一个可执行文件

查看版本 `./consul version` 

##### 集群 consul cluster

在consul方案中，每个提供服务的节点上都要部署和运行consul的agent，所有运行consul agent节点的集合构成consul cluster。

consul agent有两种运行模式：server和client。

##### 我的集群demo：

- 192.168.73.201 server
- 192.168.73.202 server
- 192.168.73.203 server

```
mkdir /home/vmuser/soft/consul
mkdir /home/vmuser/soft/consul/data
cp /home/vmuser/soft/download/consul /home/vmuser/soft/consul
```

##### 自定义配置文件

```
cd /home/vmuser/soft/consul
vim consul_config.json
```

内容如下：

```
{
  "datacenter": "consul-cluster",
  "node_name": "consul01",
  "bind_addr": "192.168.73.201",
  "client_addr": "192.168.73.201",
  "server": true,
  "bootstrap_expect": 3,
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

- bind_addr: 同命令行的-bind参数，内部集群通信绑定的地址。默认是‘0.0.0.0’，如果有多块网卡，需要指定，否则启动报错

- client_addr：同命令行的-clinet参数，客户端接口绑定的地址，默认是‘127.0.0.1’；

- server：true指定consul agent的模式为server模式；

- bootstrap_expect：同命令行的-bootstrap-expect,集群预期的server个数，这里我们有3台server，设置为3；不能和bootstrap参数一同使用。

- enable_syslog：启用则consul的日志会写进系统的syslog里；

- enable_script_checks：是否启用监控检测脚本。

详细配置参数解释见官方链接：https://www.consul.io/docs/agent/options.html

##### 启动实例

192.168.73.201 

```
nohup ./consul agent -config-file consul_config.json -ui &
```
192.168.73.202

修改配置文件中这三项
```
  "node_name": "consul01",
  "bind_addr": "192.168.73.202",
  "client_addr": "192.168.73.202",
```

```
nohup ./consul agent -config-file consul_config.json -ui &
./consul join -http-addr=192.168.73.202:8500 192.168.73.201 
```

192.168.73.203

修改配置文件中这三项
```
  "node_name": "consul01",
  "bind_addr": "192.168.73.203",
  "client_addr": "192.168.73.203",
```

```
nohup ./consul agent -config-file consul_config.json -ui &
./consul join -http-addr=192.168.73.203:8500 192.168.73.201 
```


启动之后web访问：

http://192.168.73.201:8500/

##### 其他命令

consul 可以使用命令或者使用api操作当前节点

命令 | 作用
---|---
consul members | 查看集群成员
consul leave -rpc-addr=192.168.73.203:8500 | 关闭当前节点
consul join | 加入集群

还有对ACl读写权限的操作，对KV存储的操作

http api地址：

https://www.consul.io/api/index.html


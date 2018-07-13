package com.sauzny.scdemoturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine // 此注解包含了服务注册客户端注解
public class TurbineApp {
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class);
    }
}

package com.sauzny.scdemoturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;


@SpringBootApplication
//@EnableTurbine// 此注解包含了服务注册客户端注解
@EnableTurbineStream // stream方式 使用此注解
public class TurbineApp {
    
    // TurbineStream 使用增加
    //@Bean
    //public ConfigurableCompositeMessageConverter integrationArgumentResolverMessageConverter(CompositeMessageConverterFactory factory) {
    //    return new ConfigurableCompositeMessageConverter(factory.getMessageConverterForAllRegistered().getConverters());
    //}
    
    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class);
    }
}

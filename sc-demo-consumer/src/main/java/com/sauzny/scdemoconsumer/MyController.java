package com.sauzny.scdemoconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api/consumer")
@Slf4j
public class MyController {

    @Autowired
    private MyFeignClient myFeignClient;

    @GetMapping("/peizhi")
    public String peizhi() {
        log.info("consumer say Controller peizhi() for zipkin");
        return myFeignClient.peizhi();
    }

    @GetMapping("/ling")
    public String ling() {
        log.info("consumer say Controller ling() for zipkin");
        return myFeignClient.ling();
    }

    @GetMapping("/yi")
    public String yi() {
        log.info("consumer say Controller yi() for zipkin");
        return myFeignClient.yi();
    }

    // 测试ribbon的参数
    @GetMapping("/er")
    public String er() {
        log.info("consumer say Controller er() for zipkin");
        return myFeignClient.er();
    }

    @GetMapping("/san")
    public String san() {
        log.info("consumer say Controller san() for zipkin");
        return myFeignClient.san();
    }

    @GetMapping("/ba")
    public String ba() {
        log.info("consumer say Controller ba() for zipkin");
        return myFeignClient.ba();
    }
}

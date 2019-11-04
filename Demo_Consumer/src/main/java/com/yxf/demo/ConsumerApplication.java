package com.yxf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.yxf.ribbonRule.MySelfRule;

@EnableEurekaClient
@SpringBootApplication
// 使用自定义Ribbon算法
@RibbonClient(name = "provider",configuration = MySelfRule.class)
public class ConsumerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
}

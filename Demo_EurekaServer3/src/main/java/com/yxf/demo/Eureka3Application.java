package com.yxf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* @Description: 服务发现组件启动类
* @author yuanxiaofei
* @date 2019年9月6日
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka3Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Eureka3Application.class, args);
	}

}

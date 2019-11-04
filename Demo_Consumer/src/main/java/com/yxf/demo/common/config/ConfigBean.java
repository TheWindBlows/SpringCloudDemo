package com.yxf.demo.common.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {

	@Bean
    // 需要使用负载均衡,必须与Bean一同使用
	@LoadBalanced //Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate balanceRestTemplate() {
        return new RestTemplate();
    }
    
    // 需要多个RestTemplate, 有的RestTemplate使用负载均衡，有的不使用,不使用的不增加@LoadBalanced注解
	// @Primary 出现两个类型相同时优先选择该RestTemplate
    @Primary
    @Bean
    public RestTemplate noBalanceRestTemplate() {
        return new RestTemplate();
    }
	
	/**
	 * @Description: 创建随机的Ribbon负载均衡算法，覆盖默认算法
	 * @date 2019年9月18日
	 */
	//@Bean
	public IRule myRule() {
		// 轮询算法
		// return new RoundRobinRule();
		// 访问失败后选择存货的服务进行访问
		// return new RetryRule();
		// 选择随机算法作为负载均衡算法替代默认的轮询
		return new RandomRule();
	}
}

package com.yxf.ribbonRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * @Description: 自定义配置类不能放在@ComponentScan的注解所
 * 				  扫描的包下以及子包下，否则自定义配置的类就
 * 				  会被所有Ribbon客户端所共享，这样就达不到特
 * 				  殊化定制的目的
 * @author yuanxiaofei
 * @date 2019年9月18日
 */
@Configuration
public class MySelfRule{	
	
	@Bean
	public IRule myRule() {
		// 选择随机算法作为负载均衡算法替代默认的轮询
		//return new RandomRule();
		// 自定义算法
		return new RoundFiveTimeRule();
	}
}

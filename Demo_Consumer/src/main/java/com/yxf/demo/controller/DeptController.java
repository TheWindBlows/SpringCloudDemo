package com.yxf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 部门接口
 * @author yuanxiaofei
 * @date 2019年11月4日
 */
@RequestMapping("/consumer/dept")
@RestController
public class DeptController {
	
	private static final String REST_URL_LOCAHOST = "http://provider";

	/**
	  * 调用restful服务模板,是Spring提供用于访问Rest服务的客户端工具集
	 * url参数:访问的url地址
	 * requestMap:请求参数
	 * responseBean.class:返回对象类型
	 * @LoadBalanced 选择带有负载均衡的RestTemplate
	 */
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@RequestMapping("/getDept")
	public Object getDept(@RequestParam String id) {
		return restTemplate.getForObject(REST_URL_LOCAHOST+"/dept/getDept?id="+id, Object.class);
	}
	
	@RequestMapping("/getDeptList")
	public Object getDeptList() {
		return restTemplate.getForObject(REST_URL_LOCAHOST+"/dept/getDeptList", Object.class);
	}
	
}

package com.yxf.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yxf.demo.service.fallback.DeptClientServerFallback;

/**
 * @Description: Feign调用接口
 * 传递对象参数使用@RequestBody 传递String类型使用@RequestParam("id")
 * @author yuanxiaofei
 * @date 2019年11月4日
 */
// 用过服务名称进行接口调用，出现异常调用异常处理
@FeignClient(value = "provider",fallbackFactory = DeptClientServerFallback.class)
public interface DeptClientServer {
	
	/**
	 * @Description: 获取根据id部门
	 * @date 2019年11月4日
	 */
	@RequestMapping(value = "/dept/getDept", method = RequestMethod.GET)
	public Object getDept(@RequestParam("id") String id);
	
	/**
	 * @Description: 获取所有部门
	 * @date 2019年11月4日
	 */
	@RequestMapping(value = "/dept/getDeptList", method = RequestMethod.GET)
	public Object getDeptList();

}

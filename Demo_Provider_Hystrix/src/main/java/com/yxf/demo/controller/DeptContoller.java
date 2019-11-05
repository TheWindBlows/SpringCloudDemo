package com.yxf.demo.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yxf.demo.entity.Dept;
import com.yxf.demo.enums.HttpCodeEnum;
import com.yxf.demo.exception.GenericResultBuilder;
import com.yxf.demo.service.DeptService;

/**
 * @Description: 部门
 * @date 2019年9月10日
 */
@RequestMapping("/dept")
@RestController
public class DeptContoller {
	
	@Autowired
	private DeptService deptService;
	
	/**
	 * @Description: 得到指定部门
	 * @date 2019年9月10日
	 */
	@GetMapping("/getDept")
	// 不推荐使用，高耦合，每写一个方法就需要添加一个响应方法
	@HystrixCommand(fallbackMethod = "exeptionGet")
	public Object getDept(@RequestParam String id) {
		if (StringUtils.isBlank(id)) {
			throw new RuntimeException();
		}
		Dept dept = deptService.getDept(id);
		return new GenericResultBuilder.Builder().data(dept).build();
	}
	
	/**
	 * @Description: 得到所有部门
	 * @date 2019年9月10日
	 */
	@GetMapping("/getDeptList")
	public Object getDeptList() {
		List<Dept> deptList =deptService.getDeptList();
		return new GenericResultBuilder.Builder().data(deptList).build();
	}
	
	/** 不推荐使用，高耦合，每写一个方法就需要添加一个响应方法
	 * @Description: hystrix异常处理
	 * @date 2019年11月5日
	 */
	public Object exeptionGet(@RequestParam String id) {
		return new GenericResultBuilder.Builder().code(HttpCodeEnum.PARAMES_ERROR.getCode())
				.msg(HttpCodeEnum.PARAMES_ERROR.getMsg())
				.build();
	}

}

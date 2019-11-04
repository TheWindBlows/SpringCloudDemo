package com.yxf.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.demo.service.DeptClientServer;

/**
 * @Description: 部门
 * @author yuanxiaofei
 * @date 2019年11月4日
 */
@RequestMapping("/consumerFeign/dept")
@RestController
public class DeptController {
	
	@Autowired
	private DeptClientServer deptClientServer;
	
	@PostMapping("/getDept")
	public Object getDept(@RequestParam String id) {
		return deptClientServer.getDept(id);
	}
	
	@PostMapping("/getDeptList")
	public Object getDeptList() {
		return deptClientServer.getDeptList();
	}
}

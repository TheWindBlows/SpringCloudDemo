package com.yxf.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.demo.common.mode.form.DeptAddForm;
import com.yxf.demo.entity.Dept;
import com.yxf.demo.exception.GenericResultBuilder;
import com.yxf.demo.service.DeptService;

import io.swagger.annotations.ApiOperation;

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
	 * @Description: 添加部门
	 * @date 2019年9月10日
	 */
	@ApiOperation(value = "添加部门")
	@PostMapping("/addDept")
	public Object addDept(@RequestBody DeptAddForm form) {
		deptService.addDept(form);
		return new GenericResultBuilder.Builder().build();
	}
	
	/**
	 * @Description: 得到指定部门
	 * @date 2019年9月10日
	 */
	@ApiOperation(value = "得到指定部门")
	@GetMapping("/getDept")
	public Object getDept(@RequestParam String id) {
		Dept dept = deptService.getDept(id);
		return new GenericResultBuilder.Builder().data(dept).build();
	}
	
	/**
	 * @Description: 得到所有部门
	 * @date 2019年9月10日
	 */
	@ApiOperation(value = "得到所有部门")
	@GetMapping("/getDeptList")
	public Object getDeptList() {
		List<Dept> deptList =deptService.getDeptList();
		return new GenericResultBuilder.Builder().data(deptList).build();
	}

}

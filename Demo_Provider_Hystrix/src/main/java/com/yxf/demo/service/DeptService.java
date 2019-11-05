package com.yxf.demo.service;

import java.util.List;

import com.yxf.demo.entity.Dept;

/**
* @Description: 部门接口
* @author yuanxiaofei
* @date 2019年9月10日
 */
public interface DeptService {
	
	/**
	* @Description: 获取部门
	* @date 2019年9月10日
	 */
	public Dept getDept(String id);
	
	/**
	* @Description: 获取所有部门
	* @date 2019年9月10日
	 */
	public List<Dept> getDeptList();
}

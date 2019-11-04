package com.yxf.demo.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxf.demo.common.mode.form.DeptAddForm;
import com.yxf.demo.dao.DeptRepository;
import com.yxf.demo.entity.Dept;
import com.yxf.demo.service.DeptService;

/**
* @Description: 部门接口实现
* @author yuanxiaofei
* @date 2019年9月10日
 */
@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptRepository deptRepository;

	@Override
	public boolean addDept(DeptAddForm form) {
		Dept dept = new Dept();
		BeanUtils.copyProperties(form, dept);
		deptRepository.save(dept);
		return true;
	}

	@Override
	public Dept getDept(String id) {
		return deptRepository.findOne(id);
	}

	@Override
	public List<Dept> getDeptList() {
		return deptRepository.findAll();
	}

}

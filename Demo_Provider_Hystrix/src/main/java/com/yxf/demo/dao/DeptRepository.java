package com.yxf.demo.dao;

import org.springframework.stereotype.Repository;

import com.yxf.demo.base.BaseJpaDao;
import com.yxf.demo.entity.Dept;

/**
* @Description: 部门数据层
* @author yuanxiaofei
* @date 2019年9月10日
 */
@Repository
public interface DeptRepository extends BaseJpaDao<Dept, String> {

}

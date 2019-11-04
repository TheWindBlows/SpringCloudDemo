package com.yxf.demo.base;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
* @Description: JPA基础数据层
* @author yuanxiaofei
* @date 2019年9月10日
 */
@NoRepositoryBean
public interface BaseJpaDao<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}


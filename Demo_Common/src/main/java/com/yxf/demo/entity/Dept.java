package com.yxf.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* @Description: 部门实体类
* @author yuanxiaofei
* @date 2019年9月5日
 */
@Entity
@Data
@Table(name = "Dept")
@Accessors(chain = true) // 配置getter和setter方法的生成结果,设置为链式
@AllArgsConstructor // 全参数构造函数
@NoArgsConstructor // 无参构造函数
public class Dept implements Serializable{
	
	private static final long serialVersionUID = -7841434711378382L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id; // 主键ID
	
	@Column(name = "DEPT_NAME",length = 32)
	private String dpName; // 部门名称
	
	@Column(name = "DB_SOURCE",length = 32)
	private String dbSource; // 该数据对应哪个数据库

}

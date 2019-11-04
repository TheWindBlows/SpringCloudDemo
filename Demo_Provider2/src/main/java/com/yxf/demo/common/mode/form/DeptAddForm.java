package com.yxf.demo.common.mode.form;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@ApiModel(value = "部门")
public class DeptAddForm {
	
	/** 部门名称 */
	@NotBlank(message = "部门名称为必填项")
	@ApiModelProperty(value = "部门名称", required = true)
	private String dpName;
	
	/** 数据库源 */
	@NotBlank(message = "数据库源为必填项")
	@ApiModelProperty(value = "数据库源", required = true)
	private String dbSource;

}

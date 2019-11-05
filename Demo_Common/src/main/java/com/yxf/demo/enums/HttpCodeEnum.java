package com.yxf.demo.enums;

/**
 * @Description: 响应结果枚举
 * @author yuanxiaofei
 * @date 2019年11月4日
 */
public enum HttpCodeEnum {
	
	/** 未知错误 */
	UNKOWN_ERROR(-1,"未知错误,请与管理员联系!"),
	
	/** 账号被锁，请联系管理员 */
	USER_LOCK(-100,"账号被锁，请联系管理员!"),
	
	/** 成功 */
	SUCCESS(200, "请求已成功!"),

	/** 请求参数错误 */
	PARAMES_ERROR(400, "请求参数错误!"),

	/** 权限不足,或未带token */
	SC_UNAUTHORIZED(401, "访问无效,请重新登录!"),

	/** 无权限访问 */
	FORBIDDEN(403, "禁止访问!"),

	/** 请求失败 */
	SYSTEM_ERROR(404, "请求失败!"),

	/** 参数校验 */
	PARAMES_NULL(500,"请按要求填写相应参数!"),

	/** 请登录获取TOKEN */
	TOKEN_NULL(501,"访问服务异常,请重新登录!"),
	
	/** 请登录获取TOKEN */
	TOKEN_ERROR(501,"信息失效,请重新登录!"),
	
	/** 验证码错误 */
	CODE_ERROR(505,"验证码错误!"),
	
	/** 验证码错误 */
	CODE_NULL(505,"验证码不能为空!"),

	/** 网关异常 */
	GATEWAY_ERROR(504, "网关转发超时!"),
	
	/** 服务降级已关闭 */
	HYSTRIX_ERROR(600, "服务已关闭!");
	
	private Integer code;

	private String msg;

	/**
	 * @Description: 创建一个新的实例 HttpCodeEnum
	 * @date 2019年9月10日
	 */
	private HttpCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @Description: 获取基本响应结果的Code
	 * @date 2019年9月10日
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @Description: 获取基本响应结果的Msg
	 * @date 2019年9月10日
	 */
	public String getMsg() {
		return msg;
	}


}

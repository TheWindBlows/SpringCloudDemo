package com.yxf.demo.exception;

import com.yxf.demo.enums.HttpCodeEnum;

import lombok.Getter;
import lombok.ToString;

/**
 * @Description: 基本响应结果(建造者模式)
 * @author yuanxiaofei
 * @date 2019年9月10日
 */
@Getter
@ToString
public class GenericResultBuilder {
	
	/** 返回代码。 **/
	private Integer code;

	/** 错误消息。发生错误时有返回值。 **/
	private String msg;

	/** 跳转路径 **/
	private String redirectURL;

	/** 实际返回数据 **/
	private Object data;
	
	/**
	 * @Description: 静态内部建造类  
	 * @author yuanxiaofei
	 * @date 2019年9月10日
	 */
	public static class Builder{
		
		private Integer code = HttpCodeEnum.SUCCESS.getCode();

		private String msg = "";

		private String redirectURL = "";

		private Object data = null;
		
		public Builder() {
			super();
		}
		
		/**
		 * @Description: 链式设置参数
		 * @date 2019年9月10日
		 */
		public Builder code(Integer code) {
			this.code = code;
			return this;
		}
		
		public Builder msg(String msg) {
			this.msg = msg;
			return this;
		}
		
		public Builder redirectURL(String redirectURL) {
			this.redirectURL = redirectURL;
			return this;
		}
		
		public Builder data(Object data) {
			this.data = data;
			return this;
		}
		
		/**
		 * @Description: 返回GenericResultBuilder对象
		 * @date 2019年9月10日
		 */
		public GenericResultBuilder build() {
			return new GenericResultBuilder(this);
		}
		
		
	}
	
	/**
	 * 创建一个新的实例 GenericResultBuilder
	 */
	public GenericResultBuilder(Builder builder) {
		this.code = builder.code;
		this.redirectURL = builder.redirectURL;
		this.data = builder.data;
		this.msg = builder.msg;
	}

}

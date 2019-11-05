package com.yxf.demo.service.fallback;

import org.springframework.stereotype.Component;

import com.yxf.demo.enums.HttpCodeEnum;
import com.yxf.demo.exception.GenericResultBuilder;
import com.yxf.demo.service.DeptClientServer;

import feign.hystrix.FallbackFactory;

/**
 * @Description: 添加接口的Fallback处理
 * @author yuanxiaofei
 * @date 2019年11月5日
 */
@Component // 必须添加该注解，否则无法使用
public class DeptClientServerFallback implements FallbackFactory<DeptClientServer>{

	@Override
	public DeptClientServer create(Throwable cause) {
		return new DeptClientServer() {
			
			/**
			 * @Description: 当出现异常时给出响应
			 */
			@Override
			public Object getDeptList() {
				return new GenericResultBuilder.Builder().code(HttpCodeEnum.HYSTRIX_ERROR.getCode())
						.msg(HttpCodeEnum.HYSTRIX_ERROR.getMsg())
						.build();
			}
			
			@Override
			public Object getDept(String id) {
				return new GenericResultBuilder.Builder().code(HttpCodeEnum.HYSTRIX_ERROR.getCode())
						.msg(HttpCodeEnum.HYSTRIX_ERROR.getMsg())
						.build();
			}
		};
	}

}

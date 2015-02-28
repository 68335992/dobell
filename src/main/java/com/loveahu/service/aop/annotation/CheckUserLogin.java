package com.loveahu.service.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.loveahu.constant.DoBell;

/**
 * 用户检验用户是否登录，如果没有登录，则跳转到登录页面，并提示指定信息<br/>
 * 注意：<br/>
 * 方法中必须包含HttpServletRequest<br/>
 * 用户id参数默认为uid<br/>
 * 用户Z值参数默认为txid<br/>
 *
 * @author Nye
 * @since 2011-4-27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckUserLogin {
	
	/**
	 * uid request parameter name
	 */
	public String uid() default DoBell.PARAMS_UID;
	/**
	 * txid request parameter name
	 */
	public String skey() default DoBell.PARAMS_SKEY;
	/**
	 * 提示信息
	 */
	public String tip() default "您的身份信息异常，请重新登陆";
}

package com.loveahu.service.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.loveahu.constant.DoBell;
import com.loveahu.dao.eum.ActionOp;

/**
 * 事件<br/>
 * 由于可能会有更多的前置判断，因此该切面建议作为最后定义的注解<br/>
 * 
 * @author Nye
 * @Since Jan 9, 2014
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	
	/**
	 * need request param uid or not
	 */
	public boolean needUid() default true;
	/**
	 * request param uid key 
	 */
	public String uidKey() default DoBell.PARAMS_UID;
	/**
	 * opeartion see {@link com.loveahu.dao.eum.micradio.monitor.domain.ActionOp}
	 */
	public ActionOp op();
	/**
	 * description
	 */
	public String tip() default "undefine"; 
}

package com.loveahu.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切点处理接口
 *
 * @author qinze
 * @since  Nov 8, 2010
 */
public interface IJointPointProcessor {

	public Object checkJointPoint(ProceedingJoinPoint jointPoint);
}

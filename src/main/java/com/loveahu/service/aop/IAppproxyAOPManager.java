package com.loveahu.service.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.loveahu.service.aop.annotation.Action;
import com.loveahu.service.aop.annotation.CheckUserLogin;
import com.loveahu.util.AnnotationUtils;

/**
 * 处理缓存的AOP管理器
 * 
 * @author Nye
 * @Since Nov 26, 2013
 *
 */
public abstract class IAppproxyAOPManager implements IJointPointProcessor {

	Logger log = Logger.getLogger(IAppproxyAOPManager.class);
	//身份校验
	public abstract Object checkUserLogin(ProceedingJoinPoint jointPoint,CheckUserLogin checkUserLogin,long now) throws Throwable;
	//操作记录
	public abstract void action(ProceedingJoinPoint jointPoint,Action controllerAction,long now) throws Throwable;
	
	public Object checkJointPoint(ProceedingJoinPoint jointPoint){
		long now = System.currentTimeMillis();
		String methodName = jointPoint.getSignature().getName();
		Method targetMethod = AnnotationUtils.findAnnotationByMethod(jointPoint.getTarget().getClass(), methodName);
		/**
		 * 根据注解信息,判断注解类型,并调用不同方法
		 * 前置判断
		 */
		Object o = null;
		boolean isProcess = false;
		try {
			for(Annotation annotation : targetMethod.getDeclaredAnnotations()){
				if(annotation instanceof CheckUserLogin){
					if(!isProcess){
						log.info("aop:CheckUserLogin >> "+ methodName);
						o = this.checkUserLogin(jointPoint, (CheckUserLogin)annotation,now);
						if (null!=o) {
							isProcess = true;
						}
					}
				}else if (annotation instanceof Action) {
					this.action(jointPoint, (Action)annotation, now);
				}
			}
			/**
			 * 是否执行方法
			 */
			if(!isProcess){
				o = jointPoint.proceed();
			}
		} catch (Throwable e) {
			log.error("Aop catch throwable:Method "+jointPoint.getSignature().getName(),e);
		}
		/**
		 * to check whether we need to record user action
		 */
		System.out.println("Aop Monitor: Method "+jointPoint.getSignature().getName()+" cost "+(System.currentTimeMillis()-now));
		return o;
	}
}

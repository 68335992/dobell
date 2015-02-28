package com.loveahu.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhuzhongming.tw
 * 
 */
public class AnnotationUtils {

	public static Annotation[] findAnnotationByClazz(Class<?> clazz) {
		if (clazz != null) {
			return clazz.getDeclaredAnnotations();
		}
		return null;
	}

	public static Annotation[] findAnnotationByField(Field field) {
		if (field != null) {
			return field.getDeclaredAnnotations();
		}
		return null;
	}

	public static Method findAnnotationByMethod(Class<?> clazz,
			String methodName) {
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(methodName)) {
				return method;
			}
		}
		return null;
	}

	public static Annotation[] findAnnotationByMethod(Method method) {
		if (method != null) {
			return method.getDeclaredAnnotations();
		}
		return null;
	}

	/**
	 * 
	 */
	private AnnotationUtils() {
	}
}
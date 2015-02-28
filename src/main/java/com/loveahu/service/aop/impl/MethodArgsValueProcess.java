package com.loveahu.service.aop.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;

import com.loveahu.service.aop.IValueProcess;

/**
 * 基于方法参数的value实现
 * @author qinze
 * @since  Nov 9, 2010
 */
public class MethodArgsValueProcess implements IValueProcess {

	private static final Pattern p = Pattern.compile("^\\d");

	@Override
	public List<Object> getValue(String key, Object[] args) {
		return getValueByStr(key,args);
	}

	@Override
	public boolean isValid(String key) {
		Matcher m = p.matcher(key);
		return m.find();
	}

	public static void main(String[] args){
		MethodArgsValueProcess m = new MethodArgsValueProcess();
		System.out.println(m.isValid("f.userId 12.JJ"));
	}

	/**
	 * aop的工具之一用来通过参数表解析式得到参数信息
	 *
	 * @param paramStr
	 * @param obj
	 * @return paramStr 最简单形式是 0 0.aa
	 */
	@SuppressWarnings("unchecked")
	private List<Object> getValueByStr(String paramStr, Object[] obj) {
		List<Object> ret = new ArrayList<Object>();
		String[] args = paramStr.split("\\.");
		if (args != null && args.length >= 1) {
			// 原始对象
			Object valueOrg = obj[Integer.parseInt(args[0])];
			if (valueOrg instanceof Collection) {
				for (Object childObj : (Collection) valueOrg) {
					if (args.length == 1) {
						ret.add(childObj);
						continue;
					}
					for (int i = 1; i < args.length; i++) {
						PropertyDescriptor pd = BeanUtils
								.getPropertyDescriptor(childObj.getClass(),
										args[i]);
						try {
							// 增加容错代码
							if (pd != null) {
								childObj = pd.getReadMethod().invoke(childObj);
							}
							if (i == (args.length - 1)) {
								ret.add(childObj);
							}
						} catch (IllegalArgumentException e) {
							continue;
						} catch (IllegalAccessException e) {
							continue;
						} catch (InvocationTargetException e) {
							continue;
						}
					}
				}
			} else {
				if (args.length == 1) {
					ret.add(valueOrg);
				}
				for (int i = 1; i < args.length; i++) {
					PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(
							valueOrg.getClass(), args[i]);
					try {
						// 增加容错代码
						if (pd != null) {
							valueOrg = pd.getReadMethod().invoke(valueOrg);
						}
						if (i == (args.length - 1)) {
							ret.add(valueOrg);
						}
					} catch (IllegalArgumentException e) {
						continue;
					} catch (IllegalAccessException e) {
						continue;
					} catch (InvocationTargetException e) {
						continue;
					}
				}
			}

			// return valueOrg;
		}
		return ret;
	}

}

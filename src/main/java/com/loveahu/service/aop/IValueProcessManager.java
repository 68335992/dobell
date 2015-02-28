package com.loveahu.service.aop;

import java.util.List;

/**
 * 取关键值策略接口,采用命令链模式实现.
 *
 * <简单来说就是一种参数组合的方式,将一个对象根据自己的需要,组合(取)成另一对象>
 *
 * @author qinze
 * @since  Nov 9, 2010
 */
public interface IValueProcessManager {

	/**
	 * 根据不同的策略,从args中根据key取值
	 *
	 * @param key
	 * @param args
	 * @return
	 */
	public List<Object> getValue(String key,Object[] args);
}

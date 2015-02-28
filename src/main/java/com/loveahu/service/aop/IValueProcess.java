package com.loveahu.service.aop;

import java.util.List;

/**
 * 根据key获取args值的公共接口
 * 实现该接口可以自定义处理设置注解格式以及对格式的解析.
 *
 * 即key(格式)定义在 paramList 中,实现getValue方法
 *
 * @author qinze
 * @since  Nov 9, 2010
 */
public interface IValueProcess {

	/**
	 * 判断是否应该采用该实现
	 * @param key
	 * @return
	 */
	public boolean isValid(String key);

	/**
	 * 根据key,获取args中值
	 * @param key
	 * @param args
	 * @return
	 */
	public List<Object> getValue(String key,Object[] args);
}

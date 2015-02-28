package com.loveahu.util;

import cn.com.tx.galaxy.util.StringUtil;

public class ParseUtil {

	public static Byte getByteValue(String value){
		if(StringUtil.isBlank(value)){
			return null;
		}
		try {
			return Byte.parseByte(value.trim());
		} catch (Throwable e) {
			return null;
		}
	}
	
	public static Long getLongValue(String value){
		if (StringUtil.isBlank(value)) {
			return null;
		}
		try {
			return Long.parseLong(value.trim());
		} catch (Throwable e) {
			return null;
		}
	}

}

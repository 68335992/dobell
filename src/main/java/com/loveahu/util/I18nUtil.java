package com.loveahu.util;


import java.util.Locale;

import cn.com.tx.galaxy.util.StringUtil;

public class I18nUtil {
	
	static final Locale[] LOCALE = Locale.getAvailableLocales();
	static final Locale DEFAULT_LOCALE = Locale.CHINA;

	public static Locale getLocaleByCountry(String country){
		if (StringUtil.isBlank(country)) {
			return DEFAULT_LOCALE;
		}
		for(Locale loc:LOCALE){
			if (loc.getCountry().equals(country)) {
				return loc;
			}
		}
		return DEFAULT_LOCALE;
	}
}

package com.loveahu.util;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

public class HtmlUtil {

	/**
     * 对字符串进行HTML安全转义
     *
     * @param str
     * @return
     */
    public static String toHtmlEscape(String str){
    	return HtmlUtils.htmlEscape(str);
    }

    /**
     * 对字符串进行脚本安全转义
     * @param str
     * @return
     */
    public static String toScriptEscape(String str){
    	return JavaScriptUtils.javaScriptEscape(str);
    }
}

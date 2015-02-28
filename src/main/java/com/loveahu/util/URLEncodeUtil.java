package com.loveahu.util;

import java.util.HashMap;
import java.util.Map;

public class URLEncodeUtil {

	static Map<String,String> decodeMap = new HashMap<String, String>();
	static Map<String,String> encodeMap = new HashMap<String, String>();
	
	
	static{
		decodeMap.put("\\*1", "/");
		decodeMap.put("\\*2", ".");
		decodeMap.put("\\*3", "?");
		decodeMap.put("\\*4", "&");
		decodeMap.put("\\*5", "=");	
		
		encodeMap.put("/", "*1");
		encodeMap.put("\\.", "*2");
		encodeMap.put("\\?", "*3");
		encodeMap.put("&", "*4");
		encodeMap.put("=", "*5");
		
	}
	
	/**
	 * 对转义后的url进行解析
	 * @param url
	 * @param decodeMap
	 * @return
	 */
	public static String decodeUrl(String url){
		if(null==decodeMap||decodeMap.size()<=0){
			decodeMap = new HashMap<String, String>();
	    	decodeMap.put("\\*1", "/");
	    	decodeMap.put("\\*2", ".");
	    	decodeMap.put("\\*3", "?");
	    	decodeMap.put("\\*4", "&");
	    	decodeMap.put("\\*5", "=");
		}
        for (String str:decodeMap.keySet()) {
        	url = url.replaceAll(str, decodeMap.get(str));
		}
    	return url;
    }
	
	/**
	 * 对url进行转义
	 * @param url
	 * @param hashMap
	 * @return
	 */
	public static String encodeUrl(String url){
		if(null==encodeMap||encodeMap.size()<=0){
			encodeMap = new HashMap<String, String>();
			encodeMap.put("/", "*1");
			encodeMap.put("\\.", "*2");
			encodeMap.put("\\?", "*3");
			encodeMap.put("&", "*4");
			encodeMap.put("=", "*5");
		}
        for (String str:encodeMap.keySet()) {
        	url = url.replaceAll(str, encodeMap.get(str));
		}
    	return url;
    }

}

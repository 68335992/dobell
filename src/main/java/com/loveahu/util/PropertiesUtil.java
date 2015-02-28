package com.loveahu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
	
	static Logger log = Logger.getLogger(PropertiesUtil.class);
	
	static{
		
	}
	
	private static Map<String, Map<String, String>> cache = new HashMap<String, Map<String,String>>();
	
	private synchronized static void initProperties(String fileName){
		if (!cache.containsKey(fileName)) {
			Properties props = new Properties();
			InputStream in = null;
			try {
				String filePath = System.getProperty("user.home")+System.getProperty("file.separator")+fileName;
				in = new FileInputStream(new File(filePath));
				log.info("config filepath:"+filePath);
				props.load(in);
				Enumeration en = props.propertyNames();
				Map<String, String> tmp = new HashMap<String, String>();
				while(en.hasMoreElements()){
					String key = (String) en.nextElement();
					String property = props.getProperty(key);
					log.info("key:"+key+" value:"+property);
					tmp.put(key, property);
				}
				cache.put(fileName, tmp);
			} catch (FileNotFoundException e) {
				log.error("",e);
			} catch (IOException e) {
				log.error("", e);
			} finally{
				if (null!=in) {
					try {
						in.close();
					} catch (IOException e) {
						log.error("",e);
					}
				}
			}
		}
	}
	
	public static String getProperty(String fileName,String key,String defaultValue){
		if (!cache.containsKey(fileName)) {
			initProperties(fileName);
		}
		Map<String, String> prop = cache.get(fileName);
		if (null==prop) {
			return defaultValue;
		}else{
			String o = prop.get(key);
			return o==null?defaultValue:o;
		}
	}
	
	public static int getIntProperty(String fileName,String key,int defaultValue){
		if (!cache.containsKey(fileName)) {
			initProperties(fileName);
		}
		Map<String, String> prop = cache.get(fileName);
		if (null==prop) {
			return defaultValue;
		}else{
			String o = prop.get(key);
			return o==null?defaultValue:Integer.parseInt(o);
		}
	}
	
	public static long getLongProperty(String fileName,String key,long defaultValue){
		if (!cache.containsKey(fileName)) {
			initProperties(fileName);
		}
		Map<String, String> prop = cache.get(fileName);
		if (null==prop) {
			return defaultValue;
		}else{
			String o = prop.get(key);
			return o==null?defaultValue:Long.parseLong(o);
		}
	}

}

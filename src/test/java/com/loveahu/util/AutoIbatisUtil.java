package com.loveahu.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Locale;

import com.loveahu.dao.domain.common.CommonActivityDo;
import com.loveahu.dao.domain.common.CommonPicDo;

/**
 * 自动生成ibatis配置文件
 * @author Sun
 * @since 2012-3-7
 */
public class AutoIbatisUtil {
	
	public static void main(String[] args){
		AutoIbatisUtil.run("common_activity_sqlmap.xml", CommonActivityDo.class);
	}
	
	private static final char TAB = '\t';
	private static final String ENTER = "\r\n";
	private static final String filePath = System.getProperty("user.dir")+"/";
	
	public static void run(Class<?>... clazzs){
		try {
			autoIbatis(filePath+getClassName(clazzs[0]).toLowerCase()+"_sqlmap.xml",clazzs);
			System.out.println("生成ibatis配置文件成功,文件地址为:"+filePath+getClassName(clazzs[0]).toLowerCase()+"_sqlmap.xml");
		} catch (IOException e) {
			System.out.println("生成ibatis配置文件失败");
			e.printStackTrace();
		}
	}
	
	public static void run(String fileName,Class<?>... clazzs){
		try {
			autoIbatis(filePath+fileName,clazzs);
			System.out.println("生成ibatis配置文件成功,文件地址为:"+filePath+fileName);
		} catch (IOException e) {
			System.out.println("生成ibatis配置文件失败");
			e.printStackTrace();
		}
	}

	private static void autoIbatis(String path,Class<?>... clazzs) throws IOException{
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		bw.newLine();
		bw.write("<!DOCTYPE sqlMap PUBLIC \"-//iBATIS.com//DTD SQL Map 2.0//EN\" \"http://www.ibatis.com/dtd/sql-map-2.dtd\">");
		bw.newLine();
		bw.write("<sqlMap namespace=\"请填写");
		bw.write(getPackageName(clazzs[0]));
		bw.write("\">");
		bw.newLine();
		bw.newLine();
		for(Class<?> clazz:clazzs){
			bw.write(TAB);
			bw.write("<typeAlias alias=\"");
			bw.write(getRefName(clazz));
			bw.write("\" type=\"");
			bw.write(clazz.getName());
			bw.write("\" />");
			bw.newLine();
		}
		bw.newLine();
		for(Class<?> clazz:clazzs){
			bw.write(TAB+"<resultMap id=\""+getRefName(clazz)+"Result");
			bw.write("\" class=\""+getRefName(clazz)+"\">");
			bw.newLine();
			bw.write(getFields(clazz));
			bw.write(TAB+"</resultMap>");
			bw.newLine();
			bw.newLine();
		}
		
		for(Class<?> clazz:clazzs){
			bw.write(TAB+"<select id=\"\" parameterClass=\"\" resultMap=\"\">");
			bw.newLine();
			bw.write(getSelectFields(clazz));
			bw.write(TAB+"</select>");
			bw.newLine();
			bw.newLine();
		}
		
		for(Class<?> clazz:clazzs){
			bw.write(TAB+"<insert id=\"\" parameterClass=\"\" >");
			bw.newLine();
			bw.write(getInsertFields(clazz));
			bw.write(TAB);
			bw.write(TAB);
			bw.write("<selectKey resultClass=\"java.lang.Long\" keyProperty=\"id\">");
			bw.newLine();
			bw.write(TAB);
			bw.write(TAB);
			bw.write("<![CDATA[SELECT LAST_INSERT_ID() AS ID]]>");
			bw.newLine();
			bw.write(TAB);
			bw.write(TAB);
			bw.write("</selectKey>");
			bw.newLine();
			bw.write(TAB+"</insert>");
			bw.newLine();
			bw.newLine();
		}
		
		bw.write("</sqlMap>");
		bw.close();
		fw.close();
	}
	
	private static String getPackageName(Class<?> clazz){
		String clazzTmp = clazz.toString().substring(0,clazz.toString().lastIndexOf("."));
		return clazzTmp.substring(clazzTmp.lastIndexOf(".")+1,clazzTmp.length());
	}
	
	private static String getClassName(Class<?> clazz){
		return clazz.toString().substring(clazz.toString().lastIndexOf(".")+1,clazz.toString().length());
	}
	
	private static String getRefName(Class<?> clazz){
		char[] c = new StringBuilder(clazz.toString().substring(clazz.toString().lastIndexOf(".")+1,clazz.toString().length())).toString().toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}
	
	private static String getFields(Class<?> clazz){
		StringBuilder sb = new StringBuilder();
		for(Field f:clazz.getDeclaredFields()){
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			sb.append(TAB).append(TAB).append("<result property=\"").append(f.getName()).append("\" column=\"").append(getDbColumnName(f.getName()).toUpperCase()).append("\" />").append(ENTER);
		}
		return sb.toString();
	}
	
	private static String getDbColumnName(String column){
		return column.replaceAll("([QWERTYUIOPASDFGHJKLZXCVBNM])", "_$1");
	}
	
	private static String getSelectFields(Class<?> clazz){
		StringBuilder sb = new StringBuilder();
		sb.append(TAB).append(TAB).append("SELECT"+ENTER);
		for(Field f:clazz.getDeclaredFields()){
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			sb.append(TAB).append(TAB).append(TAB).append(getDbColumnName(f.getName()).toLowerCase()).append(","+ENTER);
		}
		sb.deleteCharAt(sb.length()-3);
		sb.append(TAB).append(TAB).append(" FROM "+getClassName(clazz)+"_table"+ENTER);
		return sb.toString();
	}
	
	private static String getInsertFields(Class<?> clazz){
		StringBuilder sb = new StringBuilder();
		sb.append(TAB).append(TAB).append("INSERT INTO "+getClassName(clazz)+"_table ("+ENTER);
		for(Field f:clazz.getDeclaredFields()){
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			sb.append(TAB).append(TAB).append(TAB).append(getDbColumnName(f.getName()).toLowerCase()).append(","+ENTER);
		}
		sb.delete(sb.toString().lastIndexOf(","), sb.toString().length()-2);
		sb.append(TAB).append(TAB).append(")VALUES("+ENTER);
		for(Field f:clazz.getDeclaredFields()){
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			sb.append(TAB).append(TAB).append(TAB).append("#"+f.getName()+"#").append(","+ENTER);
		}
		sb.delete(sb.toString().lastIndexOf(","), sb.toString().length()-2);
		sb.append(TAB).append(TAB).append(")").append(ENTER);
		return sb.toString();
	}
}

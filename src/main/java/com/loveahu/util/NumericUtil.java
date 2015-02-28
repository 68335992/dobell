package com.loveahu.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class NumericUtil {
	
	public static boolean isNumeric(String str){
		if(null==str||"".equals(str)){
			return false;
		}
		return str.matches("^\\d+$");
	}

	public static boolean isNullOr0(Integer i){
		return null==i||i.equals(0);
	}

	public static boolean isNullOr0(Long i){
		return null==i||i.equals(0);
	}
	
	public static boolean isNotNullOr0(Integer i){
		return null!=i&&i>0;
	}

	public static boolean isNotNullOr0(Long i){
		return null!=i&&i>0L;
	}
	
	public static boolean isNotNullOr0(Double i){
		return null!=i&&i>0;
	}

	public static boolean isNullOr0(Double i){
		return null==i||i.equals(0);
	}
	
	public static void removeIntFromList(List<Integer> list,int i){
		Iterator<Integer> itor = list.iterator();
		while(itor.hasNext()){
			if (itor.next().equals(i)) {
				itor.remove();
				break;
			}
		}
	}
	
	public static boolean existIntInList(List<Integer> list,int i){
		for(Integer l:list){
			if (l.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static List<Integer> intToArray(Integer i){
		if (null==i) {
			return new ArrayList<Integer>();
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(i);
		return list;
	}
	
	public static Long parseLong(Object o){
		if (null==o) {
			return null;
		}
		try {
			return Long.parseLong(o.toString());
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Integer parseInteger(Object o){
		if (null==o) {
			return null;
		}
		try {
			return Integer.parseInt(o.toString());
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Byte parseByte(Object o){
		if (null==o) {
			return null;
		}
		try {
			return Byte.parseByte(o.toString());
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static char[] NUMBERS = new char[]{'1','2','3','4','5','6','7','8','9','0'};
	
	public static String getRandomNum(int length){
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();
		for(int i=0;i<length;i++){
			sb.append(NUMBERS[random.nextInt(NUMBERS.length)]);
		}
		return sb.toString();
	}
	
	private static char[] STATIC_90={
		'0','1','2','3','4','5','6','7','8','9',
		'a','b','c','d','e','f','g','h','i','j',
		'k','l','m','n','o','p','q','r','s','t',
		'u','v','w','x','y','z','A','B','C','D',
		'E','F','G','H','I','J','K','L','M','N',
		'O','P','Q','R','S','T','U','V','W','X',
		'Y','Z','!','@','#','$','%','^','&','*',
		'(',')','-','_','+','=','`','~','[','{',
		']','}','|',';',':',',','<','.','>','?'
	};
	
	/**
	 * 10进制转64进制
	 * @param d
	 * @return
	 */
	public static String D290(long d){
		StringBuilder sb = new StringBuilder();
		int k=1;
		while(Math.pow(90, k)<=d){
			k++;
		}
		for(;k>0;k--){
			int v = (int)(d/Math.pow(90, k-1));
			sb.append(STATIC_90[v]);
			d -= v * Math.pow(90, k-1);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws InterruptedException{
		while(true){
			long i = new Random().nextLong();
			i = Math.abs(i);
			System.out.println(i+" | "+D290(i));
//			Thread.sleep(100);
		}
	}
}

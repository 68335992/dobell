package com.loveahu.util;

import java.util.Random;

public class ChatUtil {

	public static String getUk(long clientId,long uid){
		return NumericUtil.D290(clientId)+' '+NumericUtil.D290(uid);
	}
	
	private static final Random random = new Random();
	
	public static long getRandomClientId(){
		return Math.abs(random.nextLong());
	}
}

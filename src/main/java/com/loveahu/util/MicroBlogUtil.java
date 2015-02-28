package com.loveahu.util;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class MicroBlogUtil {
	
	static final Random random = new Random();
	
	public static int getBrowseNum(){
		int hour = Calendar.getInstance(Locale.CHINA).get(Calendar.HOUR_OF_DAY);
		switch (hour) {
		case 0:
			return 3+random.nextInt(10);
		case 1:
			return 3+random.nextInt(6);
		case 2:
		case 3:
		case 4:
			return 2+random.nextInt(3);
		case 5:
		case 6:
		case 7:
		case 8:
			return 3+random.nextInt(4);
		case 9:
		case 10:
		case 11:
			return 5+random.nextInt(11);
		case 12:
		case 13:
			return 6+random.nextInt(11);
		case 14:
		case 15:
		case 16:
			return 6+random.nextInt(13);
		case 17:
		case 18:
			return 8+random.nextInt(11);
		case 19:
		case 20:
		case 21:
			return 4+random.nextInt(17);
		case 22:
		case 23:
		default:
			return 6+random.nextInt(13);
		}
	}
}

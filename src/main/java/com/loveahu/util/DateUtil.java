package com.loveahu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends cn.com.tx.galaxy.util.DateUtil {
	
	public static final long SECOND = 1000;
	public static final long MINUTES = SECOND * 60;
	public static final long HOUR = 60 * MINUTES;
	public static final long DAY = 24 * HOUR;
	
	public static byte birth2Age(long birth){ 
		Calendar last = Calendar.getInstance();
		byte age = 0;
		last.setTimeInMillis(birth);
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(System.currentTimeMillis());
		if ((now.get(Calendar.MONTH)>last.get(Calendar.MONTH))||(now.get(Calendar.MONTH)==last.get(Calendar.MONTH)&&(now.get(Calendar.DATE)>=last.get(Calendar.DATE)))) {
			age = (byte)(now.get(Calendar.YEAR)-last.get(Calendar.YEAR));
		}else{
			age = (byte)(now.get(Calendar.YEAR)-last.get(Calendar.YEAR)-1);
		}
		return age>0?age:0;
	}
	
	public static long age2Birth(byte age){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR)-age-1);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	public static long getCurrentDay(){
		return toDateFormat(new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()))).getTime();
	}
	public static long getCurrentHour(long ctime){
		return toDateFormat(new SimpleDateFormat("yyyy-MM-dd HH").format(new Date(ctime))).getTime();
	}
	/**
	 * 获取指定日期当前最早时刻 00:00:00
	 * @param date
	 * @return
	 */
	public static long getDayBegin(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获取指定日志当天最晚时刻 23:59:59
	 * @param date
	 * @return
	 */
	public static long getDayEnd(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 取得long时间表示的小时,最小精度小时
	 * @param mills
	 * @return
	 */
	public static String getMinute(long mills){
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		return sdf.format(new Date(mills));
	}
	
	/**
	 * 获取时间自然月的1号00:00:00
	 * @param time
	 * @return
	 */
	public static long getMonthBegin(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获取时间自然月的最后一日23:59:59
	 * @param time
	 * @return
	 */
	public static long getMonthEnd(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		cal.add(Calendar.MONDAY, 1);
		cal.set(Calendar.DATE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获取指定日期下一天 00:00:00
	 * @param date
	 * @return
	 */
	public static long getNextDay(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	/**
	 * 获取指定时间，往前推，第一个时间的分数末尾是5的时间的long
	 * @param ctime
	 * @return
	 */
	public static long getPreHour(long ctime,int time){		
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		//当前时间的分数
		int minite =  new Integer(sdf.format(ctime));
		if(minite>=0&&minite<10){
			return toDateFormat(new SimpleDateFormat("yyyy-MM-dd HH").format(new Date(ctime))).getTime()-time*60*60*1000L+10*60*1000L;
		}else {
			return toDateFormat(new SimpleDateFormat("yyyy-MM-dd HH").format(new Date(ctime))).getTime()+10*60*1000L;
		}
	}
	
	/**
	 * 获取指定时间，往前推，第一个时间的分数末尾是5的时间的long
	 * @param ctime
	 * @return
	 */
	public static long getPreLast5(long ctime,int time){		
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		long ret = 0L;
		//当前时间的分数
		int minite =  new Integer(sdf.format(ctime));
		if(minite/time==0){
			System.out.println("0 : "+(time+minite%time));
			ret = ctime - (time+minite%time)*60*1000L;
		}else if(minite/time%2==0){
			System.out.println("d : "+(minite-(minite/time-1)*time));
			ret = ctime - (minite-(minite/time-1)*time)*60*1000L;
		}else {
			System.out.println("j : "+(minite-(minite/time)*time));
			ret = ctime - (minite-(minite/time)*time)*60*1000L;
		}
		return ret;
	}
	
	/**
	 * 获取时间自然周的周一00:00:00
	 * @param time
	 * @return
	 */
	public static long getWeekBegin(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		int dayOfWeekInUs = cal.get(Calendar.DAY_OF_WEEK);
		int beginDayInCh = dayOfWeekInUs==1?-6:2-dayOfWeekInUs;
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis()+beginDayInCh*DAY;
	}
	
	/**
	 * 获取时间自然周的周日23:59:59
	 * @param time
	 * @return
	 */
	public static long getWeekEnd(long time){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		int dayOfWeekInUs = cal.get(Calendar.DAY_OF_WEEK);
		int beginDayInCh = dayOfWeekInUs==1?0:8-dayOfWeekInUs;
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTimeInMillis()+beginDayInCh*DAY;
	}
	
	/**
	 * 判断当前时间是否为晚上11点以后或7点之前
	 * @return
	 */
	public static boolean isSleepTime(){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour>22||hour<7;
	}
	
	public static String formatyyyyMMdd(long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(time);
	}
	
	public static void main(String[] args) throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		long day = 1000 * 60 * 60 * 24;
//		long now = System.currentTimeMillis();
//		for(int i=0;i<60;i++){
//			long time = now+i*day;
//			System.out.print("DATE:"+sdf.format(time)+"///");
//			System.out.print("WEEK_BEGIN:"+sdf.format(new Date(getWeekBegin(time)))+"///");
//			System.out.print("WEEK_END:"+sdf.format(new Date(getWeekEnd(time)))+"///");
//			System.out.print("MONTH_BEGIN:"+sdf.format(new Date(getMonthBegin(time)))+"///");
//			System.out.println("MONTH_END:"+sdf.format(new Date(getMonthEnd(time)))+"///");
//		}
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2013-11-5"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date me = sdf.parse("20220306");
		System.out.println(sdf.format(new Date(age2Birth((byte)1))));
	}
	
}

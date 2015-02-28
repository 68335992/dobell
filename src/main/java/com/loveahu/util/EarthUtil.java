package com.loveahu.util;

import java.math.BigDecimal;

public class EarthUtil {

	public static class CoordinateRange{
		//最大的纬度
		public double maxLatitude;
		//最小的纬度
		public double minLatitude;
		//最大的经度
		public double maxLongitude;
		//最小的经度
		public double minLongitude;
	}
	
	public static class Coordinate{
		//最大的经度
		public double longitude;
		//最大的纬度
		public double latitude;
		
		public Coordinate(){}
		
		public Coordinate(double longitude,double latitude){
			this.longitude = longitude;
			this.latitude = latitude;
		}
	}
	
//	public static class C
	//地球平均半径
	public static final double EARTH_RADIUS = 6371004d;
	
	public static final double EARTH_DIAMETER = 2*EARTH_RADIUS;
	
	public static final BigDecimal DISTANCE_DEGREE_K = new BigDecimal(111.12d);
	//默认该系统最快能接受的速度为1000KM/H. 1000*1000/60/60/1000~=0.278
	public static final double MAX_SPEED_PER_MILLIS = 0.278;
	
	private static double pi = 3.14159265358979324D;// 圆周率
	private static double a = 6378245.0D;// WGS 长轴半径
	private static double ee = 0.00669342162296594323D;// WGS 偏心率的平方
	
	/**
	 * 计算2经纬点之间距离,单位米
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public static double getDistance(double lat1, double lon1, double lat2,double lon2) {
		if (Math.abs(lat1)>90||Math.abs(lat2)>90||Math.abs(lon1)>180||Math.abs(lon2)>180) {
			return 0;
		}
        double distance = 0.0;
        double dLat = (lat2 - lat1) * Math.PI / 180;
        double dLon = (lon2 - lon1) * Math.PI / 180;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1 * Math.PI / 180)
                * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * EARTH_RADIUS;
        return distance;
    }
	
	/**
	 * 根据现实逻辑判断用于行为是否有效
	 * 如果用户在time时间内行走距离超过目前现在世界的最快速度,则认为是异常距离,并返回0
	 * @param nowLat
	 * @param nowLon
	 * @param lastLat
	 * @param lastLon
	 * @param time 间隔时间
	 * @return 单位米
	 */
	public static double getDistanceWithNaturalLogic(double nowLat,double nowLon,double lastLat,double lastLon,long time){
		if (time<0) {
			return 0;
		}
		double run = getDistance(nowLat, nowLon, lastLat, lastLon);
		if (run==0) {
			return run;
		}
		if (run>time*MAX_SPEED_PER_MILLIS) {
			return 0;
		}else{
			return run;
		}
	}
	
//	public static double getDistatce(cn.com.tx.micradio.domain.Coordinate coordinate1, cn.com.tx.micradio.domain.Coordinate coordinate2) {
//		if (null==coordinate1||null==coordinate2) {
//			return 0;
//		}
//		return getDistatce(coordinate1.getLatitude(), coordinate1.getLongitude(), coordinate2.getLatitude(), coordinate2.getLongitude());
//    }
	
	/**
	 * 根据指定经纬度获取距离为distance的坐标系
	 * 根据公式
	 * dlon = degrees(2*asin(sin(distance/)/cos(lat)))
	 * dlat = degrees(distance/settings.EARTH_RADIUS)
	 * @param latitude
	 * @param longitude
	 * @param distance 距离 单位米
	 * @return
	 */
	public static CoordinateRange getPointCoordinateByDistance(double latitude,double longitude,double distance){
		if (Math.abs(latitude)>90||Math.abs(longitude)>180||distance<0) {
			return null;
		}
		double dLon = Math.toDegrees(2*Math.asin(Math.sin(distance/EARTH_DIAMETER)/Math.cos(latitude)));
		double dLat = Math.toDegrees(distance/EARTH_RADIUS);
		CoordinateRange coordinate = new CoordinateRange();
		coordinate.maxLatitude = latitude+dLat;
		coordinate.minLatitude = latitude-dLat;
		coordinate.maxLongitude = longitude+dLon;
		coordinate.minLongitude = longitude-dLon;
		return coordinate;
	}
	
	/**
	 * 根据距离换算成度数
	 * @param distance 单位 米
	 * @return
	 */
	public static double distance2Degree(double distance){
		BigDecimal bd = new BigDecimal(distance/1000);
		return bd.divide(DISTANCE_DEGREE_K,10,BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
	
	
	
	public static void main(String[] args){
		System.out.println(distance2Degree(3000));
	}
	
	/**
	 * 中国坐标内
	 * 
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static boolean outofChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	public static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y
				+ 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}
	// 84->gcj02
	public static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1
				* Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0
				* pi)) * 2.0 / 3.0;
		return ret;
	}

	//wgs84 to gcj
	public static Coordinate wgs84ToGcj(double lon, double lat) {
		if (outofChina(lat, lon)) {
			return new Coordinate(lon, lat);
		}
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		return new Coordinate(mgLon, mgLat);
	}
	
	public static Coordinate wgs84ToBaidu(double lon,double lat){
		Coordinate gcj = wgs84ToGcj(lon, lat);
		return gcjToBaidu(gcj.longitude, gcj.latitude);
	}
	
	// gcj02 to wgs84
	public static Coordinate gcjToWgs84(double lon, double lat) {
		Coordinate gcjCoor = wgs84ToGcj(lon, lat);
		double longitude = lon - (gcjCoor.longitude- lon);
		double latitude = lat - (gcjCoor.latitude - lat);
		return new Coordinate(longitude, latitude);
	}
	
	private static final double x_pi = 3.14159265358979324 * 3000.0 / 180.0;  
	
	public static Coordinate gcjToBaidu(double lon,double lat){
		double k = Math.sqrt(lon*lon+lat*lat)+0.00002*Math.sin(lat*x_pi);
		double theta = Math.atan2(lat, lon) + 0.000003*Math.cos(lon*x_pi);
		return new Coordinate(k*Math.cos(theta)+0.0065, k*Math.sin(theta)+0.006);
	}
	
	public static boolean avaiableLongitude(Double longitude){
		if (null==longitude||longitude<-180||longitude>180) {
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean avaiableLatitude(Double latitude){
		if (null==latitude||latitude<-90||latitude>90) {
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean notAvaiableLongitude(Double longitude){
		return !avaiableLongitude(longitude);
	}
	
	public static boolean notAvaiableLatitude(Double latitude){
		return !avaiableLatitude(latitude);
	}
}

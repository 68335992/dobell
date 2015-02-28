package com.loveahu.util;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.http.HttpMethodName;
import com.baidu.inf.iis.bcs.request.GenerateUrlRequest;
import com.loveahu.constant.DoBell;

public class BCSUtil {
	
	private static final BaiduBCS baiduBCS;
	
	static{
		BCSCredentials credentials = new BCSCredentials(DoBell.BCS_AK, DoBell.BCS_sk);
		baiduBCS = new BaiduBCS(credentials, DoBell.BCS_HOST);		
		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
	}

	public static String generateUrl(String name) {
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	
	public static String getRealheadPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_HEAD_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	
	public static String getRealheadHDPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_HEAD_HD_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getRealBackgroundPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_BACK_GROUND_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getGoodImagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_GOODS_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getShareImagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_SHARE_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getShareSmallImagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_SHARE_IMAGE_SMALL_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getOrganTextSmallImagesPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_ORGAN_TEXT_IMAGE_SMALL_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getOrganTextImagesPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_ORGAN_TEXT_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getMajoyExcelUploadPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_MAJOY_EXCEL_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getHeadAnonPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_HEAD_ANON_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getHomePagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_HOMEPAGE_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getToolsYiqiPicHDPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_TOOLS_YIQI_IMAGE_HD_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getToolsYiqiPicPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_TOOLS_YIQI_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getToolLogoPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_TOOLS_LOGO_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getTipsPicPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_TOOLS_TIPS_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getmMedalImagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_MEDAL_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getBlogImagePath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_BLOG_IMAGE_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	public static String getBlogImageHDPath(String name){
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_BLOG_IMAGE_HD_PATH_OBJECT+name);
		return baiduBCS.generateUrl(generateUrlRequest);
	}
	
	
}

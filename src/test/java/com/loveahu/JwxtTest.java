package com.loveahu;

import java.io.IOException;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class JwxtTest {

	
	public static void main(String[] args) throws IOException{
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod("http://jw2.ahu.cn/xsgrxx.aspx?xh=E01114208&xm=%B3%C2%CC%EC%B4%CF&gnmkdm=N121501");
//		client.getState().addCookie(new Cookie("jw2.ahu.cn", "ASP.NET_SessionId", "ysia1u55qpdjsh3pcfyczm55"));
//		get.setRequestHeader("Host","jw2.ahu.cn");
//		get.setRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:29.0) Gecko/20100101 Firefox/29.0");
//		get.setRequestHeader("Accept-Encoding", "gzip, deflate");
//		get.setRequestHeader("Accept-Language", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		get.setRequestHeader(new Header("Referer", "http://jw2.ahu.cn/xs_main.aspx?xh=E01114208"));
		get.setRequestHeader(new Header("Cookie", "ASP.NET_SessionId=ysia1u55qpdjsh3pcfyczm55"));
		
		get.setFollowRedirects(false);
		System.out.println(client.executeMethod(get));
		System.out.println(get.getResponseBodyAsString());
		
	}
}

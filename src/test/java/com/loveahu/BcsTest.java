package com.loveahu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.http.HttpMethodName;
import com.baidu.inf.iis.bcs.request.GenerateUrlRequest;
import com.loveahu.constant.DoBell;

public class BcsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BCSCredentials credentials = new BCSCredentials(DoBell.BCS_AK, DoBell.BCS_sk);
		BaiduBCS baiduBCS = new BaiduBCS(credentials, DoBell.BCS_HOST);
		// baiduBCS.setDefaultEncoding("GBK");
		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
		GenerateUrlRequest generateUrlRequest = new GenerateUrlRequest(HttpMethodName.GET, DoBell.BCS_BUCKET, DoBell.BCS_OBJECT+"aboutahu3.jpg");
		System.out.println(baiduBCS.generateUrl(generateUrlRequest));
	}

}

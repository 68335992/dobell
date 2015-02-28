package com.loveahu;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loveahu.util.HttpConnPool;

public class HttpPoolTest {

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
	public void test1(){
		try {
			System.out.println(HttpConnPool.getInstance().post("http://api.dobell.me", null));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			Map<String, String> args = new HashMap<String, String>();
			args.put("uid", 10048+"");
			args.put("1te23", "23");
			System.out.println(HttpConnPool.getInstance().post("http://api.dobell.me/user/hi", args));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

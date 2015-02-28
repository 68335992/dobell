package com.loveahu.service;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.BaseSpringTest;
import com.loveahu.service.impl.MicroblogService;

public class MicroblogTest extends BaseSpringTest{

	MicroblogService microblogService = (MicroblogService) context.getBean("microblogService");
	
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
	public void test1() {
		List<Map<String, Object>> rst = microblogService.getMicroblogMainNewList(10046, 0, 15, 1);
		System.out.println(rst.size());
		System.out.println(JsonUtil.Object2Json(rst));
	}

}

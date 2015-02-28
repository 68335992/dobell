package com.loveahu.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loveahu.BaseSpringTest;
import com.loveahu.constant.DoBell;
import com.loveahu.dao.eum.PushType;
import com.loveahu.service.impl.PushService;

public class PushServiceTest extends BaseSpringTest {

	PushService pushService = (PushService) context.getBean("pushService");
	
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
		PushType[] types = PushType.values();
		for(PushType type:types){
			pushService.pushSingle(10078, 10046, type.type, DoBell.PUSH_DEFAULT_INFO);
			break;
		}
	}

}

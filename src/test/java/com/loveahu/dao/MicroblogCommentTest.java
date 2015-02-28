package com.loveahu.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.BaseSpringTest;

public class MicroblogCommentTest extends BaseSpringTest {

	MicroblogCommentDao microblogCommentDao = (MicroblogCommentDao) context.getBean("microblogCommentDao");
	
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
	public void testgetMicroblogCommentIdList() throws SQLException {
		List<Long> ids =  microblogCommentDao.getMicroblogCommentIdList(1556, 0, 5);
		System.out.println(JsonUtil.Object2Json(ids));
	}

}

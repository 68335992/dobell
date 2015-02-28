package com.loveahu;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.dao.domain.common.CommonUserDo;

public class DomaintSerializableTest {

	String str0 = "{\"avatarpath\":\"congcongcongcongcongcongcongcong.jpeg\",\"background\":\"default.jpeg\",\"badge\":0,\"constel\":\"\",\"depid\":-65520,\"deviid\":\"944047858118838792\",\"email\":\"\",\"emailstatus\":0,\"enrdate\":-65520,\"funcid\":\"E01114007\",\"getuiid\":\"helloworld\",\"hobby\":\"\",\"hometown\":\"\",\"lastlunchtime\":1415111349000,\"lovestatus\":\"\",\"majid\":-65520,\"namevisiable\":0,\"nickname\":\"士心QiQi\",\"oltype\":1,\"password\":\"zq267361\",\"phone\":\"\",\"phonestatus\":0,\"qq\":\"\",\"realname\":\"王志琪\",\"regdate\":1385693917000,\"schoolid\":1,\"selfintro\":\"\",\"sex\":\"女\",\"status\":1,\"uid\":10049}";
	
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
	public void testDeser() {
		CommonUserDo deser = JsonUtil.Json2T(str0, CommonUserDo.class);
		assertTrue(JsonUtil.Object2Json(deser).equals(str0));
	}

}

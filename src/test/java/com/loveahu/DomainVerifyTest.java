package com.loveahu;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.com.tx.dao.BaseDao;
import cn.com.tx.galaxy.util.JsonUtil;
import cn.com.tx.galaxy.util.StringUtil;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.loveahu.dao.AppBaseDao;
import com.loveahu.dao.CommonUserDao;
import com.loveahu.dao.domain.common.CommonActivityDo;
import com.loveahu.dao.domain.common.CommonHomepagepicDo;
import com.loveahu.dao.domain.common.CommonNoticeDo;
import com.loveahu.dao.domain.common.CommonPicDo;
import com.loveahu.dao.domain.common.CommonReportDo;
import com.loveahu.dao.domain.common.CommonSchoolDo;
import com.loveahu.dao.domain.common.CommonToolsconfigDo;
import com.loveahu.dao.domain.common.CommonUserDo;
import com.loveahu.dao.domain.common.CommonVersionDo;
import com.loveahu.dao.domain.common.CommonVersionrecordDo;
import com.loveahu.dao.domain.microblog.MicroblogAtDo;
import com.loveahu.dao.domain.microblog.MicroblogCommentDo;
import com.loveahu.dao.domain.microblog.MicroblogMainDo;
import com.loveahu.dao.domain.microblog.MicroblogPicDo;
import com.loveahu.dao.domain.microblog.MicroblogPrizeDo;
import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;
import com.loveahu.dao.domain.microblog.MicroblogZanDo;
import com.loveahu.dao.domain.school.SchoolDepartmentDo;
import com.loveahu.dao.domain.school.SchoolMajorDo;
import com.loveahu.dao.domain.user.UserFollowDo;
import com.loveahu.dao.domain.user.UserHobbyDo;
import com.loveahu.dao.domain.user.UserHobbyrecordDo;
import com.loveahu.dao.domain.user.UserRemarkDo;
import com.loveahu.dao.domain.user.UserZanDo;
import com.loveahu.service.aop.annotation.Table;
import com.loveahu.util.MysqlUtil;

public class DomainVerifyTest extends BaseSpringTest {

	Connection conn = null;
	Statement st = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		BaseDao baseDao = (BaseDao) context.getBean("baseDao");
		SqlMapClient client = baseDao.getCache().get(AppBaseDao.DS_DOBELL);
		conn = client.getDataSource().getConnection();
		st = conn.createStatement();
	}

	@After
	public void tearDown() throws Exception {
		if (null!=conn) {
			conn.close();
		}
		conn = null;
		st = null;
	}

	@Test
	public void testSpringInited() throws SQLException {
		CommonUserDao commonUserDao = (CommonUserDao) context.getBean("commonUserDao");
		CommonUserDo user = commonUserDao.getUserByUid(10048);
		System.out.println(JsonUtil.Object2Json(user));
		assertNotNull(user);
	}
	
	/**
	 * common
	 */
	@Test
	public void testCommonActivityDo(){
		assertTrue(verifyDomain(CommonActivityDo.class));
	}
	
	@Test
	public void testCommonHomepagepicDo(){
		assertTrue(verifyDomain(CommonHomepagepicDo.class));
	}
	
	@Test
	public void testCommonNoticeDo(){
		assertTrue(verifyDomain(CommonNoticeDo.class));
	}
	
	@Test
	public void testCommonPicDo(){
		assertTrue(verifyDomain(CommonPicDo.class));
	}
	
	@Test
	public void testCommonReportDo(){
		assertTrue(verifyDomain(CommonReportDo.class));
	}
	
	@Test
	public void testCommonSchoolDo(){
		assertTrue(verifyDomain(CommonSchoolDo.class));
	}
	
	@Test
	public void testCommonToolsconfigDo(){
		assertTrue(verifyDomain(CommonToolsconfigDo.class));
	}
	
	
	@Test
	public void testCommonUserDo(){
		assertTrue(verifyDomain(CommonUserDo.class));
	}
	
	@Test
	public void testCommonVersionDo(){
		assertTrue(verifyDomain(CommonVersionDo.class));
	}
	
	@Test
	public void testCommonVersionRecordDo(){
		assertTrue(verifyDomain(CommonVersionrecordDo.class));
	}
	
	/**
	 * blog
	 */
	@Test
	public void testMicroblogMain(){
		assertTrue(verifyDomain(MicroblogMainDo.class));
	}

	@Test
	public void testMicroblogAt(){
		assertTrue(verifyDomain(MicroblogAtDo.class));
	}
	/**
	 * school
	 */
	
	@Test
	public void testSchoolDepartment(){
		assertTrue(verifyDomain(SchoolDepartmentDo.class));
	}
	
	@Test
	public void testSchoolMajor(){
		assertTrue(verifyDomain(SchoolMajorDo.class));
	}
	
	/**
	 * user
	 */
	@Test
	public void testUserFollow(){
		assertTrue(verifyDomain(UserFollowDo.class));
	}
	
	@Test
	public void testUserHobby(){
		assertTrue(verifyDomain(UserHobbyDo.class));
	}
	
	@Test
	public void testUserHobbyRecord(){
		assertTrue(verifyDomain(UserHobbyrecordDo.class));
	}
	
	@Test	
	public void testMicroblogPic(){
		assertTrue(verifyDomain(MicroblogPicDo.class));
	}

	@Test
	public void testMicroblogComment(){
		assertTrue(verifyDomain(MicroblogCommentDo.class));
	}
	@Test
	public void testMicroblogPrize(){
		assertTrue(verifyDomain(MicroblogPrizeDo.class));
	}
	
	@Test
	public void testUserRemark(){
		assertTrue(verifyDomain(UserRemarkDo.class));
	}

	@Test
	public void testMicroblogShare(){
		assertTrue(verifyDomain(MicroblogShareDo.class));
	}
	@Test
	public void testMicroblogTopic(){
		assertTrue(verifyDomain(MicroblogTopicDo.class));
	}
	@Test
	public void testMicroblogZan(){
		assertTrue(verifyDomain(MicroblogZanDo.class));
	}
	
	@Test
	public void testUserZan(){
		assertTrue(verifyDomain(UserZanDo.class));
	}
	
	private boolean verifyDomain(Class<?> clazz){
		Field[] decFields = clazz.getDeclaredFields();
		Map<String, Field> fields = new HashMap<String, Field>();
		for(Field dec:decFields){
			if (Modifier.isStatic(dec.getModifiers())) {
				continue;
			}
			fields.put(dec.getName(), dec);
		}
		String tableName = null;
		Annotation[] annotations = clazz.getAnnotations();
		for(Annotation annotation:annotations){
			if (annotation instanceof Table) {
				tableName = ((Table)annotation).value();
				break;
			}
		}
		if (StringUtil.isBlank(tableName)) {
			System.out.println(clazz.getSimpleName()+" do not declare @Table");
			return false;
		}
		try {
			ResultSet rs = st.executeQuery("select * from "+tableName+" limit 0");
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			System.out.println(clazz.getSimpleName()+"field count "+fields.size()+" "+tableName+" field count "+columnCount);
			if (columnCount!=fields.size()) {
				System.out.println(clazz.getSimpleName()+" fields "+fields.size()+" "+tableName+" fields "+columnCount+" not match ");
				return false;
			}
			for(int i=1;i<=meta.getColumnCount();i++){
				String columnName = meta.getColumnName(i);
				int columnType = meta.getColumnType(i);
				Field field = fields.get(columnName);
				if (null==field) {
					System.out.println(clazz.getSimpleName()+" cannt find field "+columnName);
					return false;
				}
				if (!MysqlUtil.typeEqual(field.getGenericType(), columnType)) {
					System.out.println(clazz.getSimpleName()+" field "+field.getName()+" type["+field.getGenericType()+"] not match dbtype ["+meta.getColumnTypeName(i)+"]");
					return false;
				}
			}	
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
}

package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogTopicDo;

@Repository("microblogTopicDao")
public class MicroblogTopicDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogTopicDao.class);

	public MicroblogTopicDao() {
		super.setRoute(DS_DOBELL);
	}

	public MicroblogTopicDo getMicroblogTopicByTopicId(long topicId) throws SQLException {
		return (MicroblogTopicDo) this.executeQueryForObject(
				"microblogTopic.getMicroblogTopicByTopicId", topicId);
	}

	public long addMicroblogTopic(String topicStr,long UsrId,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_createuid",UsrId);
		map.put("_topic",topicStr);
		map.put("_schoolid",schoolId);
		return  (long) this.executeInsert("microblogTopic.addMicroblogTopic", map);
	}
	
	public Integer getMicroblogTopicNowCount(long topicId) throws SQLException{
		return (Integer) this.executeQueryForObject("microblogTopic.getMicroblogTopicNowCount", topicId);
		
	}
	
	public Long getTopicIdByTopicStr(String topicStr,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("topicStr", topicStr);
		map.put("schoolId", schoolId);
		return (Long) this.executeQueryForObject("microblogTopic.getTopicIdByTopicStr", map);
	}
	
	public List<Long> getGoodTopicIdBySchoolId(long schoolId) throws SQLException{
		return this.executeQueryForList("microblogTopic.getGoodTopicIdBySchoolId", schoolId);
	}
	
	public List<Long> getWallIngTopicIdList(long schoolId) throws SQLException{
		return this.executeQueryForList("microblogTopic.getWallIngTopicIdList", schoolId);
	}
}

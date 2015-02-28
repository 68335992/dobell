package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogMainDo;

@Repository("microblogMainDao")
public class MicroblogMainDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogMainDao.class);

	public MicroblogMainDao() {
		super.setRoute(DS_DOBELL);
	}

	public MicroblogMainDo getMicroblogMainByBlogId(long blogId) throws SQLException {
		return (MicroblogMainDo) this.executeQueryForObject(
				"microblogMain.getMicroblogMainByBlogId", blogId);
	}

	public long addMicroblogMain(long usrId,String contentStr,String mentionUsrIdStr,int imageNum,
			int isTran,long origBlogId,long transBlogId,int shareId,long topicId,long schoolId,int type) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_uid",usrId);
		map.put("_content",contentStr);
		map.put("_mentionuid",mentionUsrIdStr);
		map.put("_picnum",imageNum);
		map.put("_istran",isTran);
		map.put("_origbid",origBlogId);
		map.put("_transbid",transBlogId);
		map.put("_tid",topicId);
		map.put("_shareid",shareId);
		map.put("_schoolid",schoolId);
		map.put("_type",type);
		return  (long) this.executeInsert("microblogMain.addMicroblogMain", map);
	}
	
	public int deleteMicroblogMain(long blogId,int deleteFlag) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blogId);
		map.put("deleteFlag", deleteFlag);
		return this.executeQueryForUpdate("microblogMain.deleteMicroblogByBlogId", map);
	}
	
	public List<Long> getNewBlogIdList(long usrId,long lastId,int objCount,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		return this.executeQueryForList("microblogMain.getNewBlogIdList", map);
	}
	
	public List<Long> getHotBlogIdList(long usrId,long lastId,int objCount,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		return this.executeQueryForList("microblogMain.getHotBlogIdList", map);
	}
	
	public List<Long> getFriendBlogIdList(long usrId,long lastId,int objCount,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		return this.executeQueryForList("microblogMain.getFriendBlogIdList", map);
	}
	
	public List<Long> getGroupBlogIdList(long usrId,long lastId,int objCount,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		return this.executeQueryForList("microblogMain.getGroupBlogIdList", map);
	}
	
	public List<Long> getSomeoneBlogIdList(long usrId,long frdId,long lastId,int objCount,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		map.put("frdId", frdId);
		return this.executeQueryForList("microblogMain.getSomeoneBlogIdList", map);
	}
	
	public List<Long> getTopicBlogIdList(long usrId,long lastId,int objCount,long topicId,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("usrId", usrId);
		map.put("lastId", lastId);
		map.put("objCount", objCount);
		map.put("schoolId", schoolId);
		map.put("topicId", topicId);
		return this.executeQueryForList("microblogMain.getTopicBlogIdList", map);
	}
	
	public MicroblogMainDo getMicroblogMainById(long bid) throws SQLException{
		return (MicroblogMainDo) this.executeQueryForObject("microblogMain.getMicroblogMainById", bid);
	}
	
	public int getNowCount(long topicId) throws SQLException{
		return (Integer) this.executeQueryForObject("microblogMain.getNowCount", topicId);
	}
	
	public int increaseMblogBrowse(long bid,int num) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bid", bid);
		map.put("num", num);
		return this.executeQueryForUpdate("microblogMain.increaseMblogBrowse", map);
	}
}

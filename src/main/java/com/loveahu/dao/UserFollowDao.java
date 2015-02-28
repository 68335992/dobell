package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.user.UserFollowDo;

@Repository("userFollowDao")
public class UserFollowDao extends AppBaseDao {

	Logger log = Logger.getLogger(UserFollowDao.class);
	
	public UserFollowDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public List<Long> getAllFollowed(long toUid) throws SQLException{
		return this.executeQueryForList("userFollow.getAllFollowed", toUid);
	}
	
	public List<Long> getAllFollows(long fromUid) throws SQLException{
		return this.executeQueryForList("userFollow.getAllFollows", fromUid);
	}
	
	public UserFollowDo getFollowedStatus(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromUid", fromUid);
		map.put("toUid", toUid);
		return (UserFollowDo) this.executeQueryForObject("userFollow.getFollowedStatus", map);
	}
	
	
	public boolean resetFollow(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromUid", fromUid);
		map.put("toUid", toUid);
		return this.executeQueryForUpdate("userFollow.resetFollow", map)>0;
	}
	
	public long sendFollow(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_fromuid", fromUid);
		map.put("_touid", toUid);
		return this.executeInsert("userFollow.sendFollow", map);
	}
}

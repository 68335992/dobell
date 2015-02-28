package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.user.UserZanDo;

@Repository("userZanDao")
public class UserZanDao extends AppBaseDao {

	Logger log = Logger.getLogger(UserZanDao.class);
	
	public UserZanDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public List<UserZanDo> getHomePageZaned(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromUid", fromUid);
		map.put("toUid", toUid);
		return this.executeQueryForList("userZan.getHomePageZaned", map);
	}
	
	public Integer getUserHomePageZanCount(long toUid) throws SQLException{
		return (Integer) this.executeQueryForObject("userZan.getUserHomePageZanCount", toUid);
	}
	
	public Integer getLastZanCount(long fromUid) throws SQLException{
		Integer already = (Integer) this.executeQueryForObject("userZan.getLastZanCount", fromUid);
		return 5-(already==null?0:already);
	}
	
	public Integer getAllZanCount(long toUid) throws SQLException{
		return (Integer) this.executeQueryForObject("userZan.getAllZanCount", toUid);
	}
	
	public long sendHomePageZan(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_fromuid", fromUid);
		map.put("_touid", toUid);
		return this.executeInsert("userZan.sendHomePageZan", map);
	}
}

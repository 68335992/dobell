package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("userRemarkDao")
public class UserRemarkDao extends AppBaseDao {

	Logger log = Logger.getLogger(UserRemarkDao.class);
	
	public UserRemarkDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public String getRemark(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromUid", fromUid);
		map.put("toUid", toUid);
		return (String) this.executeQueryForObject("userRemark.getRemark", map);
	}
	
	public boolean resetRemark(long fromUid,long toUid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fromUid", fromUid);
		map.put("toUid", toUid);
		return this.executeQueryForUpdate("userRemark.resetRemark", map)>0;
	}
	
	public long sendRemark(long fromUid,long toUid,String name) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_fromuid", fromUid);
		map.put("_touid", toUid);
		map.put("_name", name);
		return this.executeInsert("userRemark.sendRemark", map);
	}
}

package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.friend.FriendMainDo;

@Repository("friendMainDao")
public class FriendMainDao extends AppBaseDao {

	Logger log = Logger.getLogger(FriendMainDao.class);
	
	public FriendMainDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public FriendMainDo getFriendMain(long uid,long fuid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("fuid", fuid);
		return (FriendMainDo) this.executeQueryForObject("friendMain.getFriendMain", map);
	}
	
	public List<Long> getFuidsByUid(long uid) throws SQLException{
		return this.executeQueryForList("friendMain.getFuidsByUid", uid);
	}
	
	public long addFriend(long uid,long fuid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("fuid", fuid);
		return this.executeInsert("friendMain.addFriend", map);
	}
	
	public boolean delFriend(long fid) throws SQLException{
		return this.executeDelete("friendMain.delFriend", fid)>0;
	}
	
	public boolean deleteFriendRecord(long uid,long fuid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("fuid", fuid);
		return this.executeQueryForUpdate("friendMain.deleteFriendRecord", map)>0;
	}
}

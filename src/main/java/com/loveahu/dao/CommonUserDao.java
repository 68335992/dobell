package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.common.CommonUserDo;

@Repository("commonUserDao")
public class CommonUserDao extends AppBaseDao {

	Logger log = Logger.getLogger(CommonUserDao.class);
	
	public CommonUserDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public CommonUserDo getUserByUid(long uid) throws SQLException{
		return  (CommonUserDo) this.executeQueryForObject("user.getUserByUid", uid);
	}
	
	public CommonUserDo getUserByFuncid(String funcId,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("funcId", funcId);
		map.put("schoolId", schoolId);
		return (CommonUserDo) this.executeQueryForObject("user.getUserByFuncid", map);
	}
	
	public Long getUsrIdByFuncId(String funcId, long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("funcId", funcId);
		map.put("schoolId", schoolId);
		Object o = this.executeQueryForObject("user.getUsrIdByFuncId", map);
		return o==null?-1:(Long)o;
	}
	
	public String getGetuiIdByUsrId(long uid) throws SQLException{
		return (String) this.executeQueryForObject("user.getGetuiIdByUsrId", uid);
	}
	
	public Byte getUserOlType(long uid) throws SQLException{
		return (Byte) this.executeQueryForObject("user.getUserOlType", uid);
	}
	
	public String getUserHeadByUsrId(long uid) throws SQLException{
		return (String) this.executeQueryForObject("user.getUserHeadByUsrId", uid);
	}
	
	public Byte getPhoneStatus(long uid) throws SQLException{
		return (Byte) this.executeQueryForObject("user.getPhoneStatus", uid);
	}
	
	public String getPhoneByFuncId(String funcId,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("funcId", funcId);
		map.put("schoolId", schoolId);
		return (String) this.executeQueryForObject("user.getPhoneByFuncId", map);
	}
	
	public String getNickByUsrId(long uid) throws SQLException{
		return (String) this.executeQueryForObject("user.getNickByUsrId", uid);
	}
	
	public Integer getUserBadge(long uid) throws SQLException{
		return (Integer) this.executeQueryForObject("user.getUserBadge", uid);
	}
	
	public Byte getUsrType(long uid) throws SQLException{
		return (Byte) this.executeQueryForObject("user.getUsrType", uid);
	}
	
	/**
	 * update 
	 */
	public boolean alterPasswordByFuncId(String funcId,String password,long schoolId) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("funcId", funcId);
		map.put("password", password);
		map.put("schoolId", schoolId);
		int rst = this.executeQueryForUpdate("user.alterPasswordByFuncId", map);
		return rst==1;
	}
	
	public boolean clearBadge(long uid) throws SQLException{
		return this.executeQueryForUpdate("user.clearBadge", uid)>0;
	}
	
	public boolean increaseBadge(long uid) throws SQLException{
		return this.executeQueryForUpdate("user.increaseBadge", uid)>0;
	}
	
	public long addCommonUser(CommonUserDo user) throws SQLException{
		return this.executeInsert("user.addCommonUser", user);
	}
}

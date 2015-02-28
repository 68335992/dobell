package com.loveahu.service;

import java.util.Map;

import com.loveahu.dao.domain.common.CommonUserDo;

public interface IUserService {

	CommonUserDo getUserByUid(long uid);
	
	CommonUserDo getUserByFuncid(String funcId, long schoolId);
	
	long getUsrIdByFuncId(String funcId, long schoolId);
	
	String getGetuiIdByUsrId(long uid);
	
	Byte getUserOlType(long uid);
	
	String getUserHeadByUsrId(long uid);
	
	Byte getPhoneStatus(long uid);
	
	String getPhoneByFuncId(String funcId,long schoolId);
	
	String getNickByUsrId(long uid);
	
	Integer getUserBadge(long uid);
	
	Byte getUsrType(long uid);
	
	boolean alterPasswordByFuncId(String funcId,String password,int schoolId);
	
	boolean clearBadge(long uid);
	
	boolean increaseBadge(long uid);
	
	long addCommonUser(CommonUserDo user);
	
	Map<String, Object> getOnePerson(long myId,long otherId);
	
}

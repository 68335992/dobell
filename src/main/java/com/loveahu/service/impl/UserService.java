package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.CommonUserDao;
import com.loveahu.dao.domain.common.CommonUserDo;
import com.loveahu.service.IFriendService;
import com.loveahu.service.ISchoolService;
import com.loveahu.service.ISnsService;
import com.loveahu.service.IUserService;
import com.loveahu.util.BCSUtil;

@Service("userService")
public class UserService implements IUserService {

	Logger log = Logger.getLogger(UserService.class);
	
	@Resource
	IFriendService friendService;
	@Resource
	ISchoolService schoolService;
	@Resource
	ISnsService snsService;
	
	@Resource
	CommonUserDao commonUserDao;
	
	@Override
	public CommonUserDo getUserByUid(long uid) {
		if (uid<1) {
			return null;
		}
		try {
			return commonUserDao.getUserByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getCommonUserByUid fail "+uid,e);
			return null;
		}
	}

	@Override
	public CommonUserDo getUserByFuncid(String funcId, long schoolId) {
		try {
			return commonUserDao.getUserByFuncid(funcId, schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUserByFuncid fail",e);
			return null;
		}
	}


	@Override
	public long getUsrIdByFuncId(String funcid, long schoolId) {
		try {
			return commonUserDao.getUsrIdByFuncId(funcid, schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUsrIdByFuncId fail",e);
			return -1;
		}
	}

	@Override
	public boolean alterPasswordByFuncId(String funcId, String password,
			int schoolId) {
		try {
			return commonUserDao.alterPasswordByFuncId(funcId, password, schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("alterPasswordByFuncId fail",e);
			return false;
		}
	}

	@Override
	public String getGetuiIdByUsrId(long uid) {
		try {
			return commonUserDao.getGetuiIdByUsrId(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getGetuiIdByUsrId fail",e);
			return null;
		}
	}

	@Override
	public Byte getUserOlType(long uid) {
		try {
			return commonUserDao.getUserOlType(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUserOlType fail",e);
			return null;
		}
	}

	@Override
	public String getUserHeadByUsrId(long uid) {
		try {
			return commonUserDao.getUserHeadByUsrId(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUserHeadByUsrId fail",e);
			return null;
		}
	}

	@Override
	public Byte getPhoneStatus(long uid) {
		try {
			return commonUserDao.getPhoneStatus(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getPhoneStatus fail",e);
			return null;
		}
	}

	@Override
	public String getPhoneByFuncId(String funcId, long schoolId) {
		try {
			return commonUserDao.getPhoneByFuncId(funcId, schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getPhoneByFuncId fail",e);
			return null;
		}
	}

	@Override
	public String getNickByUsrId(long uid) {
		try {
			return commonUserDao.getNickByUsrId(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getNickByUsrId fail",e);
			return null;
		}
	}

	@Override
	public Integer getUserBadge(long uid) {
		try {
			return commonUserDao.getUserBadge(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUserBadge fail",e);
			return null;
		}
	}

	@Override
	public Byte getUsrType(long uid) {
		try {
			return commonUserDao.getUsrType(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUsrType fail",e);
			return null;
		}
	}

	@Override
	public boolean clearBadge(long uid) {
		try {
			return commonUserDao.clearBadge(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("clearBadge fail",e);
			return false;
		}
	}

	@Override
	public boolean increaseBadge(long uid) {
		try {
			return commonUserDao.increaseBadge(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("increaseBadge fail",e);
			return false;
		}
	}

	@Override
	public long addCommonUser(CommonUserDo user) {
		try {
			return commonUserDao.addCommonUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("addCommonUser fail",e);
			return -1;
		}
	}

	@Override
	public Map<String, Object> getOnePerson(long myId, long otherId) {
		CommonUserDo user = getUserByUid(otherId);
		if (null==user) {
			return null;
		}
		int friend = friendService.getFriendRelationship(myId, otherId);
		Map<String, Object> rst = new HashMap<String, Object>();
		rst.put("personId", otherId);
		rst.put("funId", user.get_funcid());
		rst.put("sex", user.get_sex());
		rst.put("headUrl", BCSUtil.getRealheadPath(user.get_avatarpath()));
		rst.put("nickName", user.get_nickname());
		rst.put("trueName", user.get_realname());
		rst.put("status", user.get_status());
		//忽略
		//rst.put("cardState", null);
		rst.put("friendState", friend);
		rst.put("phoneVertify", user.get_phonestatus());
		rst.put("phoneNumber", user.get_phone());
		rst.put("depId", user.get_depid());
		rst.put("majId", user.get_majid());
		rst.put("depName", schoolService.getDepName(user.get_depid()));
		rst.put("majName", schoolService.getMajName(user.get_majid()));
		rst.put("enrDate", user.get_enrdate());
		rst.put("loveState", user.get_lovestatus());
		rst.put("nameVisiable", user.get_namevisiable());
		rst.put("remarkName", snsService.getRemark(myId, otherId));
		rst.put("follow", snsService.getFollowedStatus(otherId, myId));
		return rst;
	}
}

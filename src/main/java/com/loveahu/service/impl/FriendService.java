package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.FriendMainDao;
import com.loveahu.dao.domain.friend.FriendMainDo;
import com.loveahu.service.IFriendService;

@Service("friendService")
public class FriendService implements IFriendService {

	Logger log = Logger.getLogger(FriendService.class);
	
	@Resource
	FriendMainDao friendMainDao;
	
	@Override
	public boolean addFriend(long uid, long fuid) {
		if (uid==fuid) {
			return false;
		}
		if (null!=getFriendMain(uid, fuid)) {
			return false;
		}
		long fidA,fidB = 0;
		try {
			 fidA = friendMainDao.addFriend(uid, fuid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("addFriendA fail",e);
			return false;
		}
		if (fidA<0) {
			return false;
		}
		try {
			fidB = friendMainDao.addFriend(fuid, uid);
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("addFriendB fail",e);
			if (!delFriend(fidA)) {
				log.error("[NEED_DEL_FIREND_MAIN] "+fidA);
			}
			return false;
		}
		if (fidB<1) {
			if (!delFriend(fidA)) {
				log.error("[NEED_DEL_FIREND_MAIN] "+fidA);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean delFriend(long fid) {
		try {
			return friendMainDao.delFriend(fid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("delFriend fail",e);
			return false;
		}
	}

	@Override
	public FriendMainDo getFriendMain(long uid, long fuid) {
		try {
			return friendMainDao.getFriendMain(uid, fuid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getRelation fail",e);
			return null;
		}
	}

	@Override
	public boolean isFriend(long uid, long fuid) {
		return null!=getFriendMain(uid, fuid);
	}

	@Override
	public List<Long> getFuidsByUid(long uid) {
		try {
			return friendMainDao.getFuidsByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getFuidsByUid fail",e);
			return null;
		}
	}

	@Override
	public boolean deleteFriendRecord(long uid, long fuid) {
		try {
			return friendMainDao.deleteFriendRecord(uid, fuid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("deleteFriendRecord fail",e);
			return false;
		}
	}

	@Override
	public int getFriendRelationship(long auid, long buid) {
		if (auid==buid) {
			return 2;
		}
		FriendMainDo tmp = getFriendMain(auid, buid);
		if (null!=tmp) {
			return 1;
		}else{
			return 0;
		}
	}

}

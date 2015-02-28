package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.UserFollowDao;
import com.loveahu.dao.UserRemarkDao;
import com.loveahu.dao.UserZanDao;
import com.loveahu.dao.domain.user.UserFollowDo;
import com.loveahu.dao.domain.user.UserZanDo;
import com.loveahu.service.ISnsService;

@Service("snsService")
public class SnsService implements ISnsService {

	Logger log = Logger.getLogger(SnsService.class);
	
	@Resource
	UserFollowDao userFollowDao;
	
	@Resource
	UserRemarkDao userRemarkDao;
	
	@Resource
	UserZanDao userZanDao;
	
	@Override
	public List<Long> getAllFollowed(long toUid) {
		try {
			return userFollowDao.getAllFollowed(toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getAllFollowed fail",e);
			return null;
		}
	}

	@Override
	public List<Long> getAllFollows(long fromUid) {
		try {
			return userFollowDao.getAllFollows(fromUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getAllFollows fail",e);
			return null;
		}
	}

	@Override
	public UserFollowDo getFollowedStatusDo(long fromUid, long toUid) {
		try {
			return userFollowDao.getFollowedStatus(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getFollowedStatus fail",e);
			return null;
		}
	}

	@Override
	public int getFollowedStatus(long toUid, long fromUid) {
		int to2From = getFollowedStatusDo(toUid, fromUid)==null?0:1;
		int from2To = getFollowedStatusDo(fromUid, toUid)==null?0:1;
		if (to2From==1) {
			if (from2To==1) {
				return 3;
			}else{
				return 1;
			}
		}else{
			if (from2To==1) {
				return 2;
			}else{
				return 0;
			}
		}
	}

	@Override
	public boolean resetFollow(long fromUid, long toUid) {
		try {
			return userFollowDao.resetFollow(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("resetFollow fail",e);
			return false;
		}
	}

	@Override
	public long sendFollow(long fromUid, long toUid) {
		try {
			return userFollowDao.sendFollow(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("sendFollow fail",e);
			return -1;
		}
	}

	@Override
	public String getRemark(long fromUid, long toUid) {
		try {
			return userRemarkDao.getRemark(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getRemark fail",e);
			return null;
		}
	}

	@Override
	public boolean resetRemark(long fromUid, long toUid) {
		try {
			return userRemarkDao.resetRemark(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("resetRemark fail",e);
			return false;
		}
	}

	@Override
	public long sendRemark(long fromUid, long toUid, String name) {
		try {
			return userRemarkDao.sendRemark(fromUid, toUid, name);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("sendRemark fail",e);
			return -1;
		}
	}

	@Override
	public List<UserZanDo> getHomePageZaned(long fromUid, long toUid) {
		try {
			return userZanDao.getHomePageZaned(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getHomePageZaned fail",e);
			return null;
		}
	}

	@Override
	public Integer getUserHomePageZanCount(long toUid) {
		try {
			return userZanDao.getUserHomePageZanCount(toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getUserHomePageZanCount fail",e);
			return null;
		}
	}

	@Override
	public Integer getLastZanCount(long fromUid) {
		try {
			return userZanDao.getLastZanCount(fromUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getLastZanCount fail",e);
			return null;
		}
	}

	@Override
	public Integer getAllZanCount(long toUid) {
		try {
			return userZanDao.getAllZanCount(toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getAllZanCount fail",e);
			return null;
		}
	}

	@Override
	public long sendHomePageZan(long fromUid, long toUid) {
		try {
			return userZanDao.sendHomePageZan(fromUid, toUid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("sendHomePageZan fail",e);
			return -1;
		}
	}

}

package com.loveahu.service;

import java.util.List;

import com.loveahu.dao.domain.user.UserFollowDo;
import com.loveahu.dao.domain.user.UserZanDo;


public interface ISnsService {

	/**
	 * follow 
	 */

	List<Long> getAllFollowed(long toUid);
	
	List<Long> getAllFollows(long fromUid);
	
	UserFollowDo getFollowedStatusDo(long fromUid,long toUid);
	
	boolean resetFollow(long fromUid,long toUid);
	
	long sendFollow(long fromUid,long toUid);
	//0-都没有关注 1-目标关注了我 2-我关注了目标 3-相互关注
	int getFollowedStatus(long toUid,long fromUid);
	
	/**
	 * remark
	 */
	String getRemark(long fromUid,long toUid);
	
	boolean resetRemark(long fromUid,long toUid);
	
	long sendRemark(long fromUid,long toUid,String name);
	
	/**
	 * zan
	 */
	List<UserZanDo> getHomePageZaned(long fromUid,long toUid);
	
	Integer getUserHomePageZanCount(long toUid);

	Integer getLastZanCount(long fromUid);
	
	Integer getAllZanCount(long toUid);
	
	long sendHomePageZan(long fromUid,long toUid);
}

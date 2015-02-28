package com.loveahu.service;

import java.util.List;

import com.loveahu.dao.domain.friend.FriendMainDo;

public interface IFriendService {

	/**
	 * main
	 */
	FriendMainDo getFriendMain(long uid,long fuid);
	
	List<Long> getFuidsByUid(long uid);
	
	boolean addFriend(long uid,long fuid);
	
	boolean isFriend(long uid,long fuid);
	
	boolean delFriend(long fid);
	
	boolean deleteFriendRecord(long uid,long fuid);
	// 2 -> 表示自己
    // 1 -> 互为好友
    // 0 -> 不是好友,且两人都没有互发送好友请求
    //-1 -> 不是好友,A已向B发送好友请求
    //-2 -> 不是好友,B已向A发送好友请求
    //-3 -> 不是好友,两人已互相发送好友请求
	int getFriendRelationship(long auid,long buid);
}

package com.loveahu.dao.domain.friend;

public enum FriendRelation {

	MY_SELF(2),
	FRIEND(1),
	NO_FRIEND_NO_REQUEST(0),
	NO_FRIEND_A_REQUEST_B(-1),
	NO_FRIEND_B_REQUEST_A(-2),
	NO_FRIEND_REQUEST_EACH(-3);
	
	public int code;
	private FriendRelation(int code){
		this.code = code;
	}
}

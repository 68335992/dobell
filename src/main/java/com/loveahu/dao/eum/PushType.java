package com.loveahu.dao.eum;

/**
 * 推送类型
 * @author bowensun
 *
 */
public enum PushType {

	MICROBLOG_AT((byte)1,"在微博中@你了"),
	COMMENT_AT((byte)2,"在评论中@你了"),
	MICROBLOG_COMMENT((byte)3,"评论了你的微博"),
	REPLY_COMMENT((byte)4,"回复了你的评论"),
	REWARD_MICROBLOG((byte)5,"转发了你的微博"),
	FRIEND_REQUEST((byte)6,"希望成为你的好友"),
	FRIEND_FORBID((byte)7,"不愿意做你的好友 :("),
	FRIEND_MARK((byte)8,"已和您成为好友 :）"),
	SEND_CARD((byte)9,"送给您一张珍贵的名片 ❤"),
	MICROBLOG_ZAN((byte)10,"赞了你的微博!"),
	SCIPT((byte)11,"偷偷给你递来一团小纸条"),
	GROUP_NEWS((byte)12,"禀告大人,校运会有新的战况!"),
	GAME_GOD((byte)13,"该神器已经重新锻造,请在Bi的一声后滴血认主。")
	;
	
	private PushType(byte type,String tip){
		this.type =type;
		this.tip = tip;
	}
	
	public byte type;
	public String tip;
	
	public static PushType getPushType(byte op){
		PushType[] types = PushType.values();
		for(PushType type:types){
			if (op==type.type) {
				return type;
			}
		}
		return null;
	}
	
	public static boolean valid(byte type){
		PushType[] pts = PushType.values();
		for(PushType pt:pts){
			if (type==pt.type) {
				return true;
			}
		}
		return false;
	}
}

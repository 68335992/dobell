package com.loveahu.service;

public interface IPushService {

	public char PUSH_TYPE_SITUATION = '1';
	public char PUSH_TYPE_REQUEST = '2';
	public char PUSH_TYPE_FRIEND = '3';
	public char PUSH_TYPE_CARD = '4';
	public char PUSH_TYPE_SCRIP = '5';
	public char PUSH_TYPE_SPORT = '6';
	public char PUSH_TYPE_TOOLS = '7';
	
	void pushSingle(long fuid,long tuid,byte type,String info);
}

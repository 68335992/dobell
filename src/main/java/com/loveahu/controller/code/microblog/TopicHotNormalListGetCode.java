package com.loveahu.controller.code.microblog;

public enum TopicHotNormalListGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_WRONGROLLTYPE('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private TopicHotNormalListGetCode(char code){
		this.code = code;
	}
}

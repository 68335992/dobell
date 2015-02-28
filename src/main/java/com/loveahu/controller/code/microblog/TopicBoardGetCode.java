package com.loveahu.controller.code.microblog;

public enum TopicBoardGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOSCHOOL('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private TopicBoardGetCode(char code){
		this.code = code;
	}
}

package com.loveahu.controller.code.microblog;

public enum MicroblogNewListGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_NOSCHOOL('2'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogNewListGetCode(char code){
		this.code = code;
	}
}

package com.loveahu.controller.code.microblog;

public enum MicroblogDetailGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_NOSCHOOL('2'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogDetailGetCode(char code){
		this.code = code;
	}
}

package com.loveahu.controller.code.microblog;

public enum MicroblogReadUpdateCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogReadUpdateCode(char code){
		this.code = code;
	}
}

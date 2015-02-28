package com.loveahu.controller.code.microblog;

public enum MicroblogDeleteCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_NOMBLOG('2'),
	RETURN_FAIL_NOACCESS('3'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogDeleteCode(char code){
		this.code = code;
	}
}

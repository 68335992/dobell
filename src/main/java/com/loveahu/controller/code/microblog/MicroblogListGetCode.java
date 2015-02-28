package com.loveahu.controller.code.microblog;

public enum MicroblogListGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_WRONGCONTENTTYPE('2'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogListGetCode(char code){
		this.code = code;
	}
}

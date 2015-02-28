package com.loveahu.controller.code.microblog;

public enum MicroblogImageUploadCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogImageUploadCode(char code){
		this.code = code;
	}
}

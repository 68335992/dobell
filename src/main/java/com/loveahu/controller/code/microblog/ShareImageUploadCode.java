package com.loveahu.controller.code.microblog;

public enum ShareImageUploadCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private ShareImageUploadCode(char code){
		this.code = code;
	}
}

package com.loveahu.controller.code.microblog;

public enum MicroblogCommentListGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOBLOG('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogCommentListGetCode(char code){
		this.code = code;
	}
}

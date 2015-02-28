package com.loveahu.controller.code.microblog;

public enum MicroblogCommentSendCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_NOOBJ('2'),
	RETURN_FAIL_NOROOTMBLOG('3'),
	RETURN_FAIL_WRONGCONTENT('4'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogCommentSendCode(char code){
		this.code = code;
	}
}

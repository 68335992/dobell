package com.loveahu.controller.code.microblog;

public enum MicroblogZanSendCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_NOROOTMBLOG('2'),
	RETURN_FAIL_HAVEZANED('3'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private MicroblogZanSendCode(char code){
		this.code = code;
	}
}

package com.loveahu.controller.code.user;

public enum UserAlterPasswordCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOUSR('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private UserAlterPasswordCode(char code){
		this.code = code;
	}
}

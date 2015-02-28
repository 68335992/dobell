package com.loveahu.controller.code.user;

public enum UserCheckCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOACCESS('1'),
	RETURN_FAIL_REGISTERED('2'),
	RETURN_FAIL_NOSCHOOL('3'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	private UserCheckCode(char code){
		this.code = code;
	}
}

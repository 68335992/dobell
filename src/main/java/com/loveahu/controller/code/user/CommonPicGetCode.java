package com.loveahu.controller.code.user;

public enum CommonPicGetCode {

	RETURN_SUCCESS('0'),
	RETURN_FAIL_NOSCHOOL('1'),
	RETURN_FAIL_SERVICERROR('9');
	
	public char code;
	
	private CommonPicGetCode(char code){
		this.code = code;
	} 
}

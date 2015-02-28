package com.loveahu.dao.domain;

/**
 * 服务端结果包装类
 * @author bowensun
 * @since Feb 15, 2015
 *
 */
public class ResultDo {

	char code;
	
	Object data;
	
	public ResultDo(){}
	
	public ResultDo(char code,Object data){
		this.code = code;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}
}

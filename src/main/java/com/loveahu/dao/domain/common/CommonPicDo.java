package com.loveahu.dao.domain.common;

import java.io.Serializable;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_pic")
public class CommonPicDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _pid;
	
	byte _oltype;
	
	String _name;
	
	int _type;
	
	long _schoolid;
	
	int _status;

	public byte get_oltype() {
		return _oltype;
	}

	public void set_oltype(byte _oltype) {
		this._oltype = _oltype;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public int get_type() {
		return _type;
	}

	public void set_type(int _type) {
		this._type = _type;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}

	public long get_pid() {
		return _pid;
	}

	public void set_pid(long _pid) {
		this._pid = _pid;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
	
}

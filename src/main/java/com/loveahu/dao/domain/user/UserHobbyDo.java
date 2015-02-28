package com.loveahu.dao.domain.user;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_user_hobby")
public class UserHobbyDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _hobid;
	
	String _name;
	
	Date _createtime;
	
	long _createuid;
	
	long _schoolid;
	
	int _status;

	public long get_hobid() {
		return _hobid;
	}

	public void set_hobid(long _hobid) {
		this._hobid = _hobid;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public long get_createuid() {
		return _createuid;
	}

	public void set_createuid(long _createuid) {
		this._createuid = _createuid;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}
}

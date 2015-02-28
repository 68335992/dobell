package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_activity")
public class CommonActivityDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _actid;
	
	String _name;
	
	String _notice;
	
	int _type;
	
	String _medal;
	
	int _status;
	
	Date _createtime;
	
	long _schoolid;

	public long get_actid() {
		return _actid;
	}

	public void set_actid(long _actid) {
		this._actid = _actid;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_notice() {
		return _notice;
	}

	public void set_notice(String _notice) {
		this._notice = _notice;
	}

	public int get_type() {
		return _type;
	}

	public void set_type(int _type) {
		this._type = _type;
	}

	public String get_medal() {
		return _medal;
	}

	public void set_medal(String _medal) {
		this._medal = _medal;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}

}

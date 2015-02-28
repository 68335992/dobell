package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_school")
public class CommonSchoolDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _schoolid;
	
	String _cnname;
	
	String _abbr;
	
	Date _createtime;
	
	int _status;

	public String get_cnname() {
		return _cnname;
	}

	public void set_cnname(String _cnname) {
		this._cnname = _cnname;
	}

	public String get_abbr() {
		return _abbr;
	}

	public void set_abbr(String _abbr) {
		this._abbr = _abbr;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
}

package com.loveahu.dao.domain.school;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_school_major")
public class SchoolMajorDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _majid;
	
	String _name;
	
	long _depid;
	
	byte _type;
	
	Date _createtime;

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public byte get_type() {
		return _type;
	}

	public void set_type(byte _type) {
		this._type = _type;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public long get_majid() {
		return _majid;
	}

	public void set_majid(long _majid) {
		this._majid = _majid;
	}

	public long get_depid() {
		return _depid;
	}

	public void set_depid(long _depid) {
		this._depid = _depid;
	}
}

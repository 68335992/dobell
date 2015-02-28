package com.loveahu.dao.domain.school;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_school_department")
public class SchoolDepartmentDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _depid;
	
	String _name;
	
	String _fullname;
	
	long _schoolid;
	
	Date _createtime;


	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_fullname() {
		return _fullname;
	}

	public void set_fullname(String _fullname) {
		this._fullname = _fullname;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public long get_depid() {
		return _depid;
	}

	public void set_depid(long _depid) {
		this._depid = _depid;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
}

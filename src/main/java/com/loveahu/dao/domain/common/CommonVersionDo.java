package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_version")
public class CommonVersionDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _id;
	
	int _vernum;
	
	String _name;
	
	Date _createtime;
	
	Date _releasetime;
	
	String _info;
	
	int _rank;
	
	String _downurl;
	
	byte _devtype;
	
	int _status;

	public int get_vernum() {
		return _vernum;
	}

	public void set_vernum(int _vernum) {
		this._vernum = _vernum;
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

	public Date get_releasetime() {
		return _releasetime;
	}

	public void set_releasetime(Date _releasetime) {
		this._releasetime = _releasetime;
	}

	public String get_info() {
		return _info;
	}

	public void set_info(String _info) {
		this._info = _info;
	}

	public int get_rank() {
		return _rank;
	}

	public void set_rank(int _rank) {
		this._rank = _rank;
	}

	public String get_downurl() {
		return _downurl;
	}

	public void set_downurl(String _downurl) {
		this._downurl = _downurl;
	}

	public byte get_devtype() {
		return _devtype;
	}

	public void set_devtype(byte _devtype) {
		this._devtype = _devtype;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}
	
}

package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_notice")
public class CommonNoticeDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _nid;
	
	String _content;
	
	byte _type;
	
	Date _createtime;
	
	byte _status;
	
	long _schoolid;

	public String get_content() {
		return _content;
	}

	public void set_content(String _content) {
		this._content = _content;
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

	public byte get_status() {
		return _status;
	}

	public void set_status(byte _status) {
		this._status = _status;
	}

	public long get_nid() {
		return _nid;
	}

	public void set_nid(long _nid) {
		this._nid = _nid;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
}

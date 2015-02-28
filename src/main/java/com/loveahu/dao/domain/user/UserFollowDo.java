package com.loveahu.dao.domain.user;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_user_follow")
public class UserFollowDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _id;
	
	long _fromuid;
	
	long _touid;
	
	Date _createtime;
	
	byte _status;

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long get_fromuid() {
		return _fromuid;
	}

	public void set_fromuid(long _fromuid) {
		this._fromuid = _fromuid;
	}

	public long get_touid() {
		return _touid;
	}

	public void set_touid(long _touid) {
		this._touid = _touid;
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
}

package com.loveahu.dao.domain.user;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_user_zan")
public class UserZanDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _zid;
	
	long _touid;
	
	long _fromuid;
	
	Date _createtime;
	
	byte _status;
	
	int _direction;

	public long get_zid() {
		return _zid;
	}

	public void set_zid(long _zid) {
		this._zid = _zid;
	}

	public long get_touid() {
		return _touid;
	}

	public void set_touid(long _touid) {
		this._touid = _touid;
	}

	public long get_fromuid() {
		return _fromuid;
	}

	public void set_fromuid(long _fromuid) {
		this._fromuid = _fromuid;
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

	public int get_direction() {
		return _direction;
	}

	public void set_direction(int _direction) {
		this._direction = _direction;
	}
	
	
}

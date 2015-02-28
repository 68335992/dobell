package com.loveahu.dao.domain.user;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_user_hobbyrecord")
public class UserHobbyrecordDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _hreid;
	
	long _hobid;
	
	long _uid;
	
	Date _time;
	
	int _status;

	public long get_hreid() {
		return _hreid;
	}

	public void set_hreid(long _hreid) {
		this._hreid = _hreid;
	}

	public long get_hobid() {
		return _hobid;
	}

	public void set_hobid(long _hobid) {
		this._hobid = _hobid;
	}

	public long get_uid() {
		return _uid;
	}

	public void set_uid(long _uid) {
		this._uid = _uid;
	}

	public Date get_time() {
		return _time;
	}

	public void set_time(Date _time) {
		this._time = _time;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}
}

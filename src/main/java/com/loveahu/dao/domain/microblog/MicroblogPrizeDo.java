package com.loveahu.dao.domain.microblog;

import java.io.Serializable;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_prize")
public class MicroblogPrizeDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _pid;
	long _uid;
	long _hostid;
	long _actid;
	int _status;
	long _schoolid;
	public long get_pid() {
		return _pid;
	}
	public long get_uid() {
		return _uid;
	}
	public long get_hostid() {
		return _hostid;
	}
	public long get_actid() {
		return _actid;
	}
	public int get_status() {
		return _status;
	}
	public long get_schoolid() {
		return _schoolid;
	}
	public void set_pid(long _pid) {
		this._pid = _pid;
	}
	public void set_uid(long _uid) {
		this._uid = _uid;
	}
	public void set_hostid(long _hostid) {
		this._hostid = _hostid;
	}
	public void set_actid(long _actid) {
		this._actid = _actid;
	}
	public void set_status(int _status) {
		this._status = _status;
	}
	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}


}

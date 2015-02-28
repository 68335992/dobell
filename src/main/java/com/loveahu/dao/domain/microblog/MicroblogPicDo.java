package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_pic")
public class MicroblogPicDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _pid;
	long _bid;
	String _picpath;
	Date _createtime;
	byte _status;
	public long get_pid() {
		return _pid;
	}
	public long get_bid() {
		return _bid;
	}
	public String get_picpath() {
		return _picpath;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public byte get_status() {
		return _status;
	}
	public void set_pid(long _pid) {
		this._pid = _pid;
	}
	public void set_bid(long _bid) {
		this._bid = _bid;
	}
	public void set_picpath(String _picpath) {
		this._picpath = _picpath;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_status(byte _status) {
		this._status = _status;
	} 	

}

package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_zan")
public class MicroblogZanDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _zid;
	long _uid;
	long _bid;
	Date _createtime;
	int  _status;
	public long get_zid() {
		return _zid;
	}
	public long get_uid() {
		return _uid;
	}
	public long get_bid() {
		return _bid;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public int get_status() {
		return _status;
	}
	public void set_zid(long _zid) {
		this._zid = _zid;
	}
	public void set_uid(long _uid) {
		this._uid = _uid;
	}
	public void set_bid(long _bid) {
		this._bid = _bid;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_status(int _status) {
		this._status = _status;
	}
	
}

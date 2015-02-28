package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_at")
public class MicroblogAtDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _aid;
	long _hostid;
	long _fromuid;
	long _touid;
	byte _type;
	Date _createtime;
	byte _read;
	byte _ispushed;
	byte _status;
	public long get_aid() {
		return _aid;
	}
	public long get_hostid() {
		return _hostid;
	}
	public long get_fromuid() {
		return _fromuid;
	}
	public long get_touid() {
		return _touid;
	}
	public byte get_type() {
		return _type;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public byte get_read() {
		return _read;
	}
	public byte get_ispushed() {
		return _ispushed;
	}
	public byte get_status() {
		return _status;
	}
	public void set_aid(long _aid) {
		this._aid = _aid;
	}
	public void set_hostid(long _hostid) {
		this._hostid = _hostid;
	}
	public void set_fromuid(long _fromuid) {
		this._fromuid = _fromuid;
	}
	public void set_touid(long _touid) {
		this._touid = _touid;
	}
	public void set_type(byte _type) {
		this._type = _type;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_read(byte _read) {
		this._read = _read;
	}
	public void set_ispushed(byte _ispushed) {
		this._ispushed = _ispushed;
	}
	public void set_status(byte _status) {
		this._status = _status;
	} 


	

}

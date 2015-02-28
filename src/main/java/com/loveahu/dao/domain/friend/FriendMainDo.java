package com.loveahu.dao.domain.friend;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_friend_main")
public class FriendMainDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _fid;
	
	long _uid;
	
	long _fuid;
	
	long _gid;
	
	Date _createtime;
	
	String _note;
	
	byte _status;
	
	public long get_uid() {
		return _uid;
	}

	public void set_uid(long _uid) {
		this._uid = _uid;
	}

	public long get_fuid() {
		return _fuid;
	}

	public void set_fuid(long _fuid) {
		this._fuid = _fuid;
	}

	public long get_gid() {
		return _gid;
	}

	public void set_gid(long _gid) {
		this._gid = _gid;
	}

	public String get_note() {
		return _note;
	}

	public void set_note(String _note) {
		this._note = _note;
	}

	public byte get_status() {
		return _status;
	}

	public void set_status(byte _status) {
		this._status = _status;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public long get_fid() {
		return _fid;
	}

	public void set_fid(long _fid) {
		this._fid = _fid;
	}
	
}

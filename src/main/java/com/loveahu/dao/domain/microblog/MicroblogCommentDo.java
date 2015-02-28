package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_comment")
public class MicroblogCommentDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _cid;
	long _uid;
	String _content;
	long _hostbid;
	long _targetuid;
	Date _createtime;
	long _hostcid;
	String _mentionuid;
	byte _status;
	public long get_cid() {
		return _cid;
	}
	public long get_uid() {
		return _uid;
	}
	public String get_content() {
		return _content;
	}
	public long get_hostbid() {
		return _hostbid;
	}
	public long get_targetuid() {
		return _targetuid;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public long get_hostcid() {
		return _hostcid;
	}
	public String get_mentionuid() {
		return _mentionuid;
	}
	public byte get_status() {
		return _status;
	}
	public void set_cid(long _cid) {
		this._cid = _cid;
	}
	public void set_uid(long _uid) {
		this._uid = _uid;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
	public void set_hostbid(long _hostbid) {
		this._hostbid = _hostbid;
	}
	public void set_targetuid(long _targetuid) {
		this._targetuid = _targetuid;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_hostcid(long _hostcid) {
		this._hostcid = _hostcid;
	}
	public void set_mentionuid(String _mentionuid) {
		this._mentionuid = _mentionuid;
	}
	public void set_status(byte _status) {
		this._status = _status;
	} 
	
	

}

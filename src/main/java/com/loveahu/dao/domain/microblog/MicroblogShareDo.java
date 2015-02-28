package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_share")
public class MicroblogShareDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _id;
	String _source;
	String _text;
	String _image;
	String _dourl;
	Date _createtime;
	byte _status;
	
	public String get_source() {
		return _source;
	}
	public String get_text() {
		return _text;
	}
	public String get_image() {
		return _image;
	}
	public String get_dourl() {
		return _dourl;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public byte get_status() {
		return _status;
	}
	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	public void set_source(String _source) {
		this._source = _source;
	}
	public void set_text(String _text) {
		this._text = _text;
	}
	public void set_image(String _image) {
		this._image = _image;
	}
	public void set_dourl(String _dourl) {
		this._dourl = _dourl;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_status(byte _status) {
		this._status = _status;
	}


}

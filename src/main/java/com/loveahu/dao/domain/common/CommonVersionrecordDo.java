package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_versionrecord")
public class CommonVersionrecordDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _id;
	
	long _schoolid;
	
	long _verid;
	
	String _showname;
	
	Date _applytime;
	
	Date _releasetime;
	
	double _totalsize;
	
	double _addsize;
	
	String _downurl;
	
	byte _status;

	public String get_showname() {
		return _showname;
	}

	public void set_showname(String _showname) {
		this._showname = _showname;
	}

	public Date get_applytime() {
		return _applytime;
	}

	public void set_applytime(Date _applytime) {
		this._applytime = _applytime;
	}

	public Date get_releasetime() {
		return _releasetime;
	}

	public void set_releasetime(Date _releasetime) {
		this._releasetime = _releasetime;
	}

	public double get_totalsize() {
		return _totalsize;
	}

	public void set_totalsize(double _totalsize) {
		this._totalsize = _totalsize;
	}

	public double get_addsize() {
		return _addsize;
	}

	public void set_addsize(double _addsize) {
		this._addsize = _addsize;
	}

	public String get_downurl() {
		return _downurl;
	}

	public void set_downurl(String _downurl) {
		this._downurl = _downurl;
	}

	public byte get_status() {
		return _status;
	}

	public void set_status(byte _status) {
		this._status = _status;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public long get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}

	public long get_verid() {
		return _verid;
	}

	public void set_verid(long _verid) {
		this._verid = _verid;
	}
	
}

package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_report")
public class CommonReportDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _rid;
	
	long _uid;
	
	int _objtype;
	
	long _objId;
	
	int _reason;
	
	Date _createtime;
	
	int _status;

	public int get_objtype() {
		return _objtype;
	}

	public void set_objtype(int _objtype) {
		this._objtype = _objtype;
	}

	public int get_reason() {
		return _reason;
	}

	public void set_reason(int _reason) {
		this._reason = _reason;
	}

	public Date get_createtime() {
		return _createtime;
	}

	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}

	public int get_status() {
		return _status;
	}

	public void set_status(int _status) {
		this._status = _status;
	}

	public long get_rid() {
		return _rid;
	}

	public void set_rid(long _rid) {
		this._rid = _rid;
	}

	public long get_uid() {
		return _uid;
	}

	public void set_uid(long _uid) {
		this._uid = _uid;
	}

	public long get_objId() {
		return _objId;
	}

	public void set_objId(long _objId) {
		this._objId = _objId;
	}
	
}

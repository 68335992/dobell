package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_toolsconfig")
public class CommonToolsconfigDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _id;
	
	String _name;
	
	String _url;
	
	double _version;
	
	int _page;
	
	int _islarge;
	
	String _largeicon;
	
	String _smallicon;
	
	int _isnative;
	
	int _nativetype;
	
	String _jsname;
	
	String _sharesite;
	
	int _needshare;
	
	int _visiable;
	
	int _available;
	
	int _guestvisiable;
	
	int _guestavailable;
	
	String _text;
	
	String _unavailabletext;
	
	int _colortype;
	
	int _index;
	
	int _oltype;
	
	int _schoolid;
	
	Date _createtime;
	
	int _status;

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_url() {
		return _url;
	}

	public void set_url(String _url) {
		this._url = _url;
	}

	public double get_version() {
		return _version;
	}

	public void set_version(double _version) {
		this._version = _version;
	}

	public int get_page() {
		return _page;
	}

	public void set_page(int _page) {
		this._page = _page;
	}

	public int get_islarge() {
		return _islarge;
	}

	public void set_islarge(int _islarge) {
		this._islarge = _islarge;
	}

	public String get_largeicon() {
		return _largeicon;
	}

	public void set_largeicon(String _largeicon) {
		this._largeicon = _largeicon;
	}

	public String get_smallicon() {
		return _smallicon;
	}

	public void set_smallicon(String _smallicon) {
		this._smallicon = _smallicon;
	}

	public int get_isnative() {
		return _isnative;
	}

	public void set_isnative(int _isnative) {
		this._isnative = _isnative;
	}

	public int get_nativetype() {
		return _nativetype;
	}

	public void set_nativetype(int _nativetype) {
		this._nativetype = _nativetype;
	}

	public String get_jsname() {
		return _jsname;
	}

	public void set_jsname(String _jsname) {
		this._jsname = _jsname;
	}

	public String get_sharesite() {
		return _sharesite;
	}

	public void set_sharesite(String _sharesite) {
		this._sharesite = _sharesite;
	}

	public int get_needshare() {
		return _needshare;
	}

	public void set_needshare(int _needshare) {
		this._needshare = _needshare;
	}

	public int get_visiable() {
		return _visiable;
	}

	public void set_visiable(int _visiable) {
		this._visiable = _visiable;
	}

	public int get_available() {
		return _available;
	}

	public void set_available(int _available) {
		this._available = _available;
	}

	public int get_guestvisiable() {
		return _guestvisiable;
	}

	public void set_guestvisiable(int _guestvisiable) {
		this._guestvisiable = _guestvisiable;
	}

	public int get_guestavailable() {
		return _guestavailable;
	}

	public void set_guestavailable(int _guestavailable) {
		this._guestavailable = _guestavailable;
	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}

	public String get_unavailabletext() {
		return _unavailabletext;
	}

	public void set_unavailabletext(String _unavailabletext) {
		this._unavailabletext = _unavailabletext;
	}

	public int get_colortype() {
		return _colortype;
	}

	public void set_colortype(int _colortype) {
		this._colortype = _colortype;
	}

	public int get_index() {
		return _index;
	}

	public void set_index(int _index) {
		this._index = _index;
	}

	public int get_oltype() {
		return _oltype;
	}

	public void set_oltype(int _oltype) {
		this._oltype = _oltype;
	}

	public int get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(int _schoolid) {
		this._schoolid = _schoolid;
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

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}
	
}

package com.loveahu.dao.domain.common;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_common_user")
public class CommonUserDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	long _uid;
	
	String _funcid;
	
	String _deviid;
	
	String _nickname;
	
	String _realname;
	
	byte _namevisiable;
	
	String _password;
	
	long _depid;
	
	long _majid;
	
	int _enrdate;
	
	String _hometown;
	
	String _hobby;
	
	String _constel;
	
	String _lovestatus;
	
	byte _status;
	
	String _email;
	
	byte _emailstatus;
	
	Date _regdate;
	
	String _sex;
	
	String _avatarpath;
	
	String _background;
	
	String _phone;
	
	byte _phonestatus;
	
	String _qq;
	
	String _selfintro;
	
	int _badge;
	
	byte _oltype;
	
	String _getuiid;
	
	Date _lastlunchtime;
	
	int _schoolid;

	public String get_funcid() {
		return _funcid;
	}

	public void set_funcid(String _funcid) {
		this._funcid = _funcid;
	}

	public String get_deviid() {
		return _deviid;
	}

	public void set_deviid(String _deviid) {
		this._deviid = _deviid;
	}

	public String get_nickname() {
		return _nickname;
	}

	public void set_nickname(String _nickname) {
		this._nickname = _nickname;
	}

	public String get_realname() {
		return _realname;
	}

	public void set_realname(String _realname) {
		this._realname = _realname;
	}

	public byte get_namevisiable() {
		return _namevisiable;
	}

	public void set_namevisiable(byte _namevisiable) {
		this._namevisiable = _namevisiable;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public int get_enrdate() {
		return _enrdate;
	}

	public void set_enrdate(int _enrdate) {
		this._enrdate = _enrdate;
	}

	public String get_hometown() {
		return _hometown;
	}

	public void set_hometown(String _hometown) {
		this._hometown = _hometown;
	}

	public String get_hobby() {
		return _hobby;
	}

	public void set_hobby(String _hobby) {
		this._hobby = _hobby;
	}

	public String get_constel() {
		return _constel;
	}

	public void set_constel(String _constel) {
		this._constel = _constel;
	}

	public String get_lovestatus() {
		return _lovestatus;
	}

	public void set_lovestatus(String _lovestatus) {
		this._lovestatus = _lovestatus;
	}

	public byte get_status() {
		return _status;
	}

	public void set_status(byte _status) {
		this._status = _status;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public byte get_emailstatus() {
		return _emailstatus;
	}

	public void set_emailstatus(byte _emailstatus) {
		this._emailstatus = _emailstatus;
	}

	public Date get_regdate() {
		return _regdate;
	}

	public void set_regdate(Date _regdate) {
		this._regdate = _regdate;
	}

	public String get_sex() {
		return _sex;
	}

	public void set_sex(String _sex) {
		this._sex = _sex;
	}

	public String get_avatarpath() {
		return _avatarpath;
	}

	public void set_avatarpath(String _avatarpath) {
		this._avatarpath = _avatarpath;
	}

	public String get_background() {
		return _background;
	}

	public void set_background(String _background) {
		this._background = _background;
	}

	public String get_phone() {
		return _phone;
	}

	public void set_phone(String _phone) {
		this._phone = _phone;
	}

	public byte get_phonestatus() {
		return _phonestatus;
	}

	public void set_phonestatus(byte _phonestatus) {
		this._phonestatus = _phonestatus;
	}

	public String get_qq() {
		return _qq;
	}

	public void set_qq(String _qq) {
		this._qq = _qq;
	}

	public String get_selfintro() {
		return _selfintro;
	}

	public void set_selfintro(String _selfintro) {
		this._selfintro = _selfintro;
	}

	public int get_badge() {
		return _badge;
	}

	public void set_badge(int _badge) {
		this._badge = _badge;
	}

	public byte get_oltype() {
		return _oltype;
	}

	public void set_oltype(byte _oltype) {
		this._oltype = _oltype;
	}

	public String get_getuiid() {
		return _getuiid;
	}

	public void set_getuiid(String _getuiid) {
		this._getuiid = _getuiid;
	}

	public Date get_lastlunchtime() {
		return _lastlunchtime;
	}

	public void set_lastlunchtime(Date _lastlunchtime) {
		this._lastlunchtime = _lastlunchtime;
	}

	public int get_schoolid() {
		return _schoolid;
	}

	public void set_schoolid(int _schoolid) {
		this._schoolid = _schoolid;
	}

	public long get_uid() {
		return _uid;
	}

	public void set_uid(long _uid) {
		this._uid = _uid;
	}

	public long get_depid() {
		return _depid;
	}

	public void set_depid(long _depid) {
		this._depid = _depid;
	}

	public long get_majid() {
		return _majid;
	}

	public void set_majid(long _majid) {
		this._majid = _majid;
	}
}

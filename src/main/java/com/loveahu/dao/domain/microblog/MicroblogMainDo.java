package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_main")
public class MicroblogMainDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _bid;
	long _uid;
	String _content;
	Date _createtime;
	Date _lasttime;
	String _mentionuid;
	int _picnum;
	int _commnum;
	int _trannum;
	int _zannum;
	int _istran;
	long _origbid;
	long _transbid;
	int _coins;
	double _hot;
	byte _hotrank;
	byte _recrank;
	byte _status;
	long _tid;
	long _shareid;
	long _schoolid;
	int _browsenum;
	int _type;
	public long get_bid() {
		return _bid;
	}
	public long get_uid() {
		return _uid;
	}
	public String get_content() {
		return _content;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public Date get_lasttime() {
		return _lasttime;
	}
	public String get_mentionuid() {
		return _mentionuid;
	}
	public int get_picnum() {
		return _picnum;
	}
	public int get_commnum() {
		return _commnum;
	}
	public int get_trannum() {
		return _trannum;
	}
	public int get_zannum() {
		return _zannum;
	}
	public int get_istran() {
		return _istran;
	}
	public long get_origbid() {
		return _origbid;
	}
	public long get_transbid() {
		return _transbid;
	}
	public int get_coins() {
		return _coins;
	}
	public double get_hot() {
		return _hot;
	}
	public byte get_hotrank() {
		return _hotrank;
	}
	public byte get_recrank() {
		return _recrank;
	}
	public byte get_status() {
		return _status;
	}
	public long get_tid() {
		return _tid;
	}
	public long get_shareid() {
		return _shareid;
	}
	public long get_schoolid() {
		return _schoolid;
	}
	public int get_browsenum() {
		return _browsenum;
	}
	public int get_type() {
		return _type;
	}
	public void set_bid(long _bid) {
		this._bid = _bid;
	}
	public void set_uid(long _uid) {
		this._uid = _uid;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_lasttime(Date _lasttime) {
		this._lasttime = _lasttime;
	}
	public void set_mentionuid(String _mentionuid) {
		this._mentionuid = _mentionuid;
	}
	public void set_picnum(int _picnum) {
		this._picnum = _picnum;
	}
	public void set_commnum(int _commnum) {
		this._commnum = _commnum;
	}
	public void set_trannum(int _trannum) {
		this._trannum = _trannum;
	}
	public void set_zannum(int _zannum) {
		this._zannum = _zannum;
	}
	public void set_istran(int _istran) {
		this._istran = _istran;
	}
	public void set_origbid(long _origbid) {
		this._origbid = _origbid;
	}
	public void set_transbid(long _transbid) {
		this._transbid = _transbid;
	}
	public void set_coins(int _coins) {
		this._coins = _coins;
	}
	public void set_hot(double _hot) {
		this._hot = _hot;
	}
	public void set_hotrank(byte _hotrank) {
		this._hotrank = _hotrank;
	}
	public void set_recrank(byte _recrank) {
		this._recrank = _recrank;
	}
	public void set_status(byte _status) {
		this._status = _status;
	}
	public void set_tid(long _tid) {
		this._tid = _tid;
	}
	public void set_shareid(long _shareid) {
		this._shareid = _shareid;
	}
	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
	public void set_browsenum(int _browsenum) {
		this._browsenum = _browsenum;
	}
	public void set_type(int _type) {
		this._type = _type;
	}



}

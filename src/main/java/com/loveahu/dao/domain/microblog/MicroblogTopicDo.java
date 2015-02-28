package com.loveahu.dao.domain.microblog;

import java.io.Serializable;
import java.util.Date;

import com.loveahu.service.aop.annotation.Table;

@Table("ds_microblog_topic")
public class MicroblogTopicDo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	long _tid;
	String _topic;
	Double _hot;
	Date _createtime;
	long _createuid;
	int _coins;
	int  _status;
	long _schoolid;
	String _tip;
	String _intro;
	int _recrank;
	int _type;
	int _good;
	public int get_good() {
		return _good;
	}
	public void set_good(int _good) {
		this._good = _good;
	}
	public long get_tid() {
		return _tid;
	}
	public String get_topic() {
		return _topic;
	}
	public Double get_hot() {
		return _hot;
	}
	public Date get_createtime() {
		return _createtime;
	}
	public long get_createuid() {
		return _createuid;
	}
	public int get_coins() {
		return _coins;
	}
	public int get_status() {
		return _status;
	}
	public long get_schoolid() {
		return _schoolid;
	}
	public String get_tip() {
		return _tip;
	}
	public String get_intro() {
		return _intro;
	}
	public int get_recrank() {
		return _recrank;
	}
	public int get_type() {
		return _type;
	}
	public void set_tid(long _tid) {
		this._tid = _tid;
	}
	public void set_topic(String _topic) {
		this._topic = _topic;
	}
	public void set_hot(Double _hot) {
		this._hot = _hot;
	}
	public void set_createtime(Date _createtime) {
		this._createtime = _createtime;
	}
	public void set_createuid(long _createuid) {
		this._createuid = _createuid;
	}
	public void set_coins(int _coins) {
		this._coins = _coins;
	}
	public void set_status(int _status) {
		this._status = _status;
	}
	public void set_schoolid(long _schoolid) {
		this._schoolid = _schoolid;
	}
	public void set_tip(String _tip) {
		this._tip = _tip;
	}
	public void set_intro(String _intro) {
		this._intro = _intro;
	}
	public void set_recrank(int _recrank) {
		this._recrank = _recrank;
	}
	public void set_type(int _type) {
		this._type = _type;
	}
}

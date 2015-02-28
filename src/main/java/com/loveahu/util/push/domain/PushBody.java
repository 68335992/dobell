package com.loveahu.util.push.domain;

import java.io.Serializable;

public class PushBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	char type;
	
	String tip;
	
	String topic;
	
	String content;
	
	String info;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
}

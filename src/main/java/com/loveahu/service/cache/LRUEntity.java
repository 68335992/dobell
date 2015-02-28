package com.loveahu.service.cache;

public class LRUEntity<T> {

	private T value;
	
	private long ctime;
	
	public LRUEntity(){}
	
	public LRUEntity(T value,long ctime){
		this.value = value;
		this.ctime = ctime;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
}

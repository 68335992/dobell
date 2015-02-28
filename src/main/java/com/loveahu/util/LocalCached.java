package com.loveahu.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LocalCached<K, V> {
	
  public static final int FIFO = 1;
  
  public static final int LRU = 2;
  
  private static final int DEFAUTLT_SIZE = 10;
  
  private Map<K, V> cacheObject;
  
  public LocalCached(){
	  this(DEFAUTLT_SIZE);
  }
  public LocalCached(final int size){
	  this(size,FIFO);
  }
  public LocalCached(final int size,final int policy){
   switch(policy){
		case FIFO:
			cacheObject = new LinkedHashMap<K, V>(size) {
				@Override
				protected boolean removeEldestEntry(Entry<K, V> eldest) {
					return size() > size;
				}

			};
			break;
		case LRU:
			cacheObject = new LinkedHashMap<K, V>(size, 0.75f, true) {
				@Override
				protected boolean removeEldestEntry(Entry<K, V> eldest) {
					return size() > size;
				}

			};
			break;
		}
  }

	public void clear() {
		cacheObject.clear();
	}

	public V get(K key) {
		return cacheObject.get(key);
	}

	public Collection listValue() {
		return cacheObject.values();
	}

	public void put(K key, V value) {
		cacheObject.put(key, value);
	}

	public void remove(K key) {
		cacheObject.remove(key);
	}
}
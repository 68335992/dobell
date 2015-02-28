package com.loveahu.service.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 线程安全的LRU缓存 增加元数据超时功能
 * @author Nye
 * @Since Nov 26, 2013
 *
 * @param <K>
 * @param <V> V为null时不存储
 */
public class LRUCache<K, V> {

	private static final float hashTableLoadFactor = 0.75f;

	private LinkedHashMap<K, LRUEntity<V>> map;
	private int cacheSize;
	private long overdue = 0L;

	/**
	 * @param cacheSize 最大容量
	 * @param overdue 单个元素最大有效时间,超过这个时间就会被踢出.0为无限制
	 */
	public LRUCache(int cacheSize, long overdue) {
		if (overdue < 0) {
			throw new RuntimeException("LRUCACHE overdue must > 0");
		}
		this.cacheSize = cacheSize;
		this.overdue = overdue;
		int hashTableCapacity = (int) Math
				.ceil(cacheSize / hashTableLoadFactor) + 1;
		map = new LinkedHashMap<K, LRUEntity<V>>(hashTableCapacity,
				hashTableLoadFactor, true) {
			private static final long serialVersionUID = 1;

			@Override
			protected boolean removeEldestEntry(
					Map.Entry<K, LRUEntity<V>> eldest) {
				return size() > LRUCache.this.cacheSize;
			}
		};
	}

	public synchronized V get(K key) {
		LRUEntity<V> entity = map.get(key);
		if (null==entity) {
			return null;
		}
		if (overdue <= 0) {
			return entity.getValue();
		}
		if ((System.currentTimeMillis() - entity.getCtime()) < overdue) {
			return entity.getValue();
		} else {
			map.remove(key);
			return null;
		}
	}

	public synchronized void put(K key, V value) {
		if (null==value) {
			return;
		}
		LRUEntity<V> entity = new LRUEntity<V>(value,overdue>0?System.currentTimeMillis():0);
		map.put(key, entity);
	}

	/**
	 * Clears the cache.
	 */
	public synchronized void clear() {
		map.clear();
	}

	public synchronized int usedEntries() {
		return map.size();
	}
	
	public void remove(K key){
		map.remove(key);
	}

//	public synchronized Collection<Map.Entry<K, V>> getAll() {
//		return new ArrayList<Map.Entry<K, V>>(map.entrySet());
//	}
	
	@Override
	public synchronized String toString() {
		Iterator<LRUEntity<V>> objs = map.values().iterator();
		StringBuilder sb = new StringBuilder("[");
		while (objs.hasNext()) {
			LRUEntity<V> obj = objs.next();
			sb.append("{").append(obj.getValue()).append(",").append(obj.getCtime()).append("},");
		}
		if (sb.length()>1) {
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		LRUCache<String, String> cache = new LRUCache<String, String>(10,100000);
		for (int i = 0; i < 100; i++) {
			cache.put(i + "", i + "");
		}
		System.out.println(cache.toString());
		for (int i = 90; i < 100; i++) {
			if (i != 94) {
				cache.get(i + "");
			}
		}
		cache.put("100", "100");
		System.out.println(cache.toString());
		for (int i = 90; i < 101; i++) {
			if (i != 97) {
				cache.get(i + "");
			}
		}
		cache.put("94", "94");
		System.out.println(cache.toString());
	}
}

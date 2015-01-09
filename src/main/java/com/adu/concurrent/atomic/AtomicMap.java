package com.adu.concurrent.atomic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMap {
	private ConcurrentHashMap<Integer, AtomicInteger> map = new ConcurrentHashMap<Integer, AtomicInteger>();

	public int get(int key) {
		int res = 0;
		if (map.contains(key)) {
			res = map.get(key).get();
		}
		return res;
	}

	public int incrementAndGet(int key) {
		int res = 1;
		if (map.contains(key)) {
			res = map.get(key).incrementAndGet();
		} else {
			AtomicInteger atomic = new AtomicInteger(1);
			map.put(key, atomic);
		}
		return res;
	}

	public int addAndGet(int key, int count) {
		int res = 0;
		if (map.containsKey(key)) {
			res = map.get(key).addAndGet(count);
		} else {
			AtomicInteger atomic = new AtomicInteger(count);
			map.put(key, atomic);
			res = count;
		}
		return res;
	}

	public Map<Integer, Integer> reset() {
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		Iterator<Map.Entry<Integer, AtomicInteger>> iter = map.entrySet()
				.iterator();

		while (iter.hasNext()) {
			Map.Entry<Integer, AtomicInteger> entry = iter.next();
			int key = entry.getKey();
			int value = entry.getValue().get();
			res.put(key, value);
		}
		return res;
	}
}

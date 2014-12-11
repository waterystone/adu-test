package com.adu.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ConcurrentHashMapTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		logger.debug("map1=" + map);

		Iterator<Map.Entry<Integer, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			if (entry.getKey() < 10) {
				iter.remove();
			}
		}
		logger.debug("map2=" + map);
		map.put(3, "b");
		logger.debug("map3=" + map);
	}
}

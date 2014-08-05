package com.adu.concurrent;

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
		logger.debug(map);
	}
}

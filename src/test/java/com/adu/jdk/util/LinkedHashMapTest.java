package com.adu.jdk.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedHashMapTest {
	private LinkedHashMap<String, Integer> map;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void insertOrder() {
		this.map = new LinkedHashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		map.get("b");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			logger.debug(entry.toString());
		}
	}

	@Test
	public void accessOrder() {
		this.map = new LinkedHashMap<String, Integer>(16, 0.75f, true);
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);

		map.get("b");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			logger.debug(entry.toString());
		}
	}

}

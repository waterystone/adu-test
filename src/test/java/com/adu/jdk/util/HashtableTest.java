package com.adu.jdk.util;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HashtableTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		table.put(1, "a");
		table.put(2, "b");
		table.put(3, "c");
		for (Map.Entry<Integer, String> entry : table.entrySet()) {
			logger.debug(entry.getKey() + ":" + entry.getValue());
		}
	}
}

package com.adu.jdk.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HashSetTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("c");
		logger.debug(set);
	}
}

package com.adu.jdk.util;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TreeSetTest {
	private final Log logger = LogFactory.getLog(TreeSetTest.class);

	@Test
	public void test() {
		Set<String> set = new TreeSet<String>();
		set.add("a");
		set.add("c");
		set.add("b");
		set.add("c");
		logger.debug(set);

	}

}

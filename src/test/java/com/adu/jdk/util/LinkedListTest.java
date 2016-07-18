package com.adu.jdk.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LinkedListTest {
	private final Log logger = LogFactory.getLog(LinkedListTest.class);

	@Test
	public void subList() {
		List<String> list = Arrays.asList("1", "2", "3");
		logger.debug(list.subList(3, 4));
	}

	@Test
	public void test() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		logger.debug(list);
	}

}

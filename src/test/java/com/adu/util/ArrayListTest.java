package com.adu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ArrayListTest {
	private final Log logger = LogFactory.getLog(ArrayListTest.class);

	@Test
	public void subList() {
		List<String> list = Arrays.asList("1", "2", "3");
		logger.debug(list.subList(3, 4));
	}

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		logger.debug(list);
	}

}

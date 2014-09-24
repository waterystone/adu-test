package com.adu.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ListTest {
	private final Log logger = LogFactory.getLog(ListTest.class);

	@Test
	public void subList() {
		List<String> list = Arrays.asList("1", "2", "3");
		logger.debug(list.subList(3, 4));
	}

	@Test
	public void test() {
		List<String> list = Arrays.asList(" 1 ", " 2", "3");
		for (String str : list) {
			str = str.trim();
			int a = 1;
		}
		logger.debug("list=" + list);
	}

}

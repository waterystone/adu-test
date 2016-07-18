package com.adu.jdk.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ArraysTest {
	private final Log logger = LogFactory.getLog(ArraysTest.class);

	@Test
	public void asList() {
		List<String> list = Arrays.asList("1", "2", "3");
		logger.debug(list.size());
		list.add("4");
		logger.debug(list);
	}

}

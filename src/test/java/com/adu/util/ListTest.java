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
		logger.debug(list.subList(0, list.size()));
	}

}

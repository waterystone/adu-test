package com.adu.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class DateTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		long now = System.currentTimeMillis();
		logger.debug(now);
	}
}

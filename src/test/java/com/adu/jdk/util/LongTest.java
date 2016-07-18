package com.adu.jdk.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LongTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void max() {
		long max = Long.MAX_VALUE;
		logger.debug("max=" + max);

	}
}

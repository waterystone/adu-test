package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MathTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void abs() {
		int res = Math.abs(-1);
		logger.debug("res=" + res);
	}
}

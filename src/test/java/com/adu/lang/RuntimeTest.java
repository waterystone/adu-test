package com.adu.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class RuntimeTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void availableProcessors() {
		int res = Runtime.getRuntime().availableProcessors();
		logger.debug("res=" + res);

	}
}

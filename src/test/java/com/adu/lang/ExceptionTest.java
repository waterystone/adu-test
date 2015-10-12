package com.adu.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ExceptionTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		Exception res = new Exception();
		logger.debug("res=" + res);
	}
}

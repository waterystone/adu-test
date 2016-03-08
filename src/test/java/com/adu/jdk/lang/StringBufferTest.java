package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringBufferTest {
	private final Log logger = LogFactory.getLog(StringBufferTest.class);

	@Test
	public void test() {
		StringBuffer buffer = new StringBuffer();
		logger.debug(buffer.toString());
	}

}

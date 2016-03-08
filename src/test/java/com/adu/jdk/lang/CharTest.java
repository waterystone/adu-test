package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class CharTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		char res = '中';
		logger.debug("res=" + res);
	}
}

package com.adu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MyStringUtilTest {
	private static Log logger = LogFactory.getLog(MyStringUtilTest.class);

	@Test
	public void decodeToUTF8() {
		logger.debug(MyStringUtil.decodeToUTF8("hello,world!"));
	}
}

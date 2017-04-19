package com.adu.org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringUtilsTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		String str = "[3-2-5, 3-2-6]";
		String res = StringUtils.substring(str, 1, -1);
		logger.debug("res=" + res);
	}

	@Test
	public void test2() {
		String str = "ab";
		boolean res = StringUtils.equals("*",str);
		logger.debug("res=" + res);
	}
}

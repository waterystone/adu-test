package com.adu.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class IntegerTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void integer() {
		String str = "20923561";
		Integer ret = new Integer(str);
		logger.debug("ret=" + ret);
	}

	@Test
	public void parseInt() {
		String str = "2820923561";
		int ret = Integer.parseInt(str);
		logger.debug("ret=" + ret);
	}

	@Test
	public void maxValue() {
		int ret = Integer.MAX_VALUE;
		logger.debug("ret=" + ret);
	}
}

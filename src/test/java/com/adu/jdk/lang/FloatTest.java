package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class FloatTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void valueOf() {
		String str = "0.00";
		float ret = Float.valueOf(str);
		logger.debug("ret=" + ret);
		logger.debug(ret == 0);
	}

}

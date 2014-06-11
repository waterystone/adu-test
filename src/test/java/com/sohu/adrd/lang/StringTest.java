package com.sohu.adrd.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class StringTest {
	private final Log logger = LogFactory.getLog(StringTest.class);

	@Test
	public void equals() {
		String str = "1";
		logger.debug(str.equals(null));
	}

}

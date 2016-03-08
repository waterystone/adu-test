package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class OjbectTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void hashCodeTest() {
		Object obj = new Object();
		int res = obj.hashCode();
		logger.debug("res=" + res);
	}
}

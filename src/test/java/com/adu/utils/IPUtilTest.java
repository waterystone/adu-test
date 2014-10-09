package com.adu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class IPUtilTest {
	private static Log logger = LogFactory.getLog(IPUtilTest.class);

	@Test
	public void getLocalIP() {
		String res = IPUtil.getLocalIp();
		logger.debug(res);
	}
}

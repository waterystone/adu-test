package com.adu.jdk.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class InetAddressTest {
	private Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws UnknownHostException {
		String ret = InetAddress.getLocalHost().getHostAddress();
		logger.debug("ret=" + ret);
	}

}

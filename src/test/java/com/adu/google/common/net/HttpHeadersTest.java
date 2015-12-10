package com.adu.google.common.net;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.HttpHeaders;

public class HttpHeadersTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void userAgent() {
		String res = HttpHeaders.USER_AGENT;
		logger.debug("res={}", res);
	}

}

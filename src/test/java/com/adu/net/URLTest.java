package com.adu.net;

import java.net.URL;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLTest {
	private URL url = this.getClass().getResource("/");
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getPath() {
		String res = url.getPath();
		logger.debug("res={}", res);
	}

	@Test
	public void getFile() {
		String res = url.getFile();
		logger.debug("res={}", res);
	}

}

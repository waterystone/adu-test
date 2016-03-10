package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void getPid() {
		int res = ConfigUtil.getPid();
		logger.debug("res={}", res);
	}

}

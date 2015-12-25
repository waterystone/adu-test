package com.adu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {

		String res = "hello,world!";
		res = Long.MAX_VALUE + "";
		logger.debug("res={}", res);
	}

}

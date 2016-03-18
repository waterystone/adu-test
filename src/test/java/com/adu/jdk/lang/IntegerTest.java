package com.adu.jdk.lang;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntegerTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		Integer a = 1, b = 1;
		Integer c = new Integer(1), d = new Integer(1);
		logger.debug("res={}", a == b);
		logger.debug("res={}", a.equals(b));
		logger.debug("res={}", c == d);
		logger.debug("res={}", c.equals(d));
	}

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

	@Test
	public void vauleOf() {
		Integer int1 = Integer.valueOf(-129);
		Integer int2 = Integer.valueOf(-129);
		logger.debug("res={}", int1 == int2);
	}
}

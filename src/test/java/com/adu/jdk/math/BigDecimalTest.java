package com.adu.jdk.math;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void toStringTest() {
		BigDecimal res = new BigDecimal(22.75);
		logger.debug("res={}", res);
	}

}

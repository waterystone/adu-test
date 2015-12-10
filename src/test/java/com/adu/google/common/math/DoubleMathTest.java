package com.adu.google.common.math;

import java.math.RoundingMode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.math.DoubleMath;

public class DoubleMathTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void roundToInt() {
		int res = DoubleMath.roundToInt(3.24234, RoundingMode.HALF_UP);
		logger.debug("res={}", res);
	}

}

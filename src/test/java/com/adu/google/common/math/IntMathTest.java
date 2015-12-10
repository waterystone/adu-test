package com.adu.google.common.math;

import java.math.RoundingMode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.math.IntMath;

public class IntMathTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void checkedAdd() {
		int res = IntMath.checkedAdd(Integer.MAX_VALUE, -1);
		logger.debug("res={}", res);
	}

	@Test
	public void divide() {
		int res = IntMath.divide(2, 3, RoundingMode.HALF_UP);
		logger.debug("res={}", res);
	}

	@Test
	public void pow() {
		int res = IntMath.pow(2, 5);
		logger.debug("res={}", res);
	}

	@Test
	public void log2() {
		int res = IntMath.log2(10, RoundingMode.HALF_UP);
		logger.debug("res={}", res);
	}

	@Test
	public void log10() {
		int res = IntMath.log10(10, RoundingMode.HALF_UP);
		logger.debug("res={}", res);
	}

	@Test
	public void sqrt() {
		int res = IntMath.sqrt(10, RoundingMode.HALF_UP);
		logger.debug("res={}", res);
	}

	@Test
	public void gcd() {
		int res = IntMath.gcd(4, 6);
		logger.debug("res={}", res);
	}

	@Test
	public void isPowerOfTwo() {
		boolean res = IntMath.isPowerOfTwo(16);
		logger.debug("res={}", res);
	}

	@Test
	public void factorial() {
		int res = IntMath.factorial(5);
		logger.debug("res={}", res);
	}

	@Test
	public void binomial() {
		int res = IntMath.binomial(1, 1);
		logger.debug("res={}", res);
	}

}

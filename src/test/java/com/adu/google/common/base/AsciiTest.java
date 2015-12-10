package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Ascii;

public class AsciiTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void space() {
		byte res = Ascii.SPACE;
		logger.debug("res={}", res);
	}

	@Test
	public void toLowerCase() {
		String str = "Hello,World!";
		String res = Ascii.toLowerCase(str);
		logger.debug("res={}", res);
	}

	@Test
	public void toUpperCase() {
		String str = "Hello,World!";
		String res = Ascii.toUpperCase(str);
		logger.debug("res={}", res);
	}

	@Test
	public void isLowerCase() {
		boolean res = Ascii.isLowerCase('a');
		logger.debug("res={}", res);
	}

	@Test
	public void isUpperCase() {
		boolean res = Ascii.isUpperCase('A');
		logger.debug("res={}", res);
	}

}

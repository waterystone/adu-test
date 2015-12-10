package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class StringsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void isNullOrEmpty() {
		boolean res = Strings.isNullOrEmpty("");
		logger.debug("res={}", res);
	}

	@Test
	public void emptyToNull() {
		String res = Strings.emptyToNull("");
		logger.debug("res={}", res);
	}

	@Test
	public void nullToEmpty() {
		String res = Strings.nullToEmpty(null);
		logger.debug("res={}", res);
	}

	@Test
	public void padStart() {
		String res = Strings.padStart("12", 4, '0');
		logger.debug("res={}", res);
	}

	@Test
	public void padEnd() {
		String res = Strings.padEnd("12", 4, '0');
		logger.debug("res={}", res);
	}

	@Test
	public void commonPrefix() {
		String a = "abcdef", b = "abcfe";
		String res = Strings.commonPrefix(a, b);
		logger.debug("res={}", res);
	}

	@Test
	public void commonSuffix() {
		String a = "abcdefsdfsabc", b = "abcfebc";
		String res = Strings.commonSuffix(a, b);
		logger.debug("res={}", res);
	}

}

package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

public class CaseFormatTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void lowerCamel() {
		CaseFormat res = CaseFormat.LOWER_CAMEL;
		logger.debug("res={}", res);
	}

	@Test
	public void to() {
		String res = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "lowerCamel");
		logger.debug("res={}", res);
	}

}

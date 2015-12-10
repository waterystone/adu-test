package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Defaults;

public class DefaultsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void defaultValue() {
		Boolean res = Defaults.defaultValue(boolean.class);
		logger.debug("res={}", res);
	}

}

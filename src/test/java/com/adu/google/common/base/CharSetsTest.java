package com.adu.google.common.base;

import java.nio.charset.Charset;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class CharSetsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void utf8() {
		Charset res = Charsets.UTF_8;
		logger.debug("res={}", res);
	}

}

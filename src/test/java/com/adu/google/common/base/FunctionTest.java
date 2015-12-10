package com.adu.google.common.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

public class FunctionTest {
	private Function<String, Integer> function;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void apply() {
		String str = "hello,world!";
		int res = function.apply(str);
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		function = new Function<String, Integer>() {

			@Override
			public Integer apply(String input) {
				return StringUtils.length(input);
			}
		};
	}

}

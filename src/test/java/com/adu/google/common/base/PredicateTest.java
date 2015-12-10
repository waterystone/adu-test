package com.adu.google.common.base;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Predicate;

public class PredicateTest {
	private Predicate<String> predicate;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void apply() {
		String str = "hello,world!";
		boolean res = predicate.apply(str);
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		predicate = new Predicate<String>() {

			@Override
			public boolean apply(String input) {
				return input.isEmpty();
			}
		};
	}

}

package com.adu;

import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		String res = "hello,world!";
		logger.debug("res={}", res);
	}

	private void printSet(Set<? extends Object> set) {
		int index = 0;
		for (Object obj : set) {
			logger.debug("[" + (index++) + "]:\"" + obj + "\"");
		}
	}

}

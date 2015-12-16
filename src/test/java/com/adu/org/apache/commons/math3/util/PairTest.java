package com.adu.org.apache.commons.math3.util;

import org.apache.commons.math3.util.Pair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PairTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		Pair<String, Integer> res = new Pair<String, Integer>("a", 1);
		logger.debug("res={}", res);
	}

}

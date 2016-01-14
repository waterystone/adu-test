package com.adu.google.common.collect.immutable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

public class ImmutableMapTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void of() {
		ImmutableMap<String, Integer> res = ImmutableMap.of("a", 1, "b", 2);
		logger.debug("res={}", res);
	}

	@Test
	public void build() {
		ImmutableMap<String, Integer> res = ImmutableMap.<String, Integer> builder().put("a", 1).put("b", 2).build();
		logger.debug("res={}", res);
	}

}

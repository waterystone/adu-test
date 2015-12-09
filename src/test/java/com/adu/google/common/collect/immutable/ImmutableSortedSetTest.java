package com.adu.google.common.collect.immutable;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;

public class ImmutableSortedSetTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void of() {
		ImmutableSortedSet<String> res = ImmutableSortedSet.of("a", "b", "a");
		logger.debug("res={}", res);
	}

	@Test
	public void asList() {
		ImmutableSortedSet<String> set = ImmutableSortedSet.of("a", "b", "a");
		ImmutableList<String> res = set.asList();
		logger.debug("res={}", res);
	}

}

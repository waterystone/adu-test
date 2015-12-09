package com.adu.google.common.collect;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class IterablesTest {
	private List<Integer> list = Ints.asList(1, 2, 2, 3, 3, 3);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void concat() {
		Iterable<String> res = Iterables.concat(Lists.newArrayList("a", "b", "c"), Lists.newArrayList("1", "2", "3"));
		logger.debug("res={}", res);
	}

	@Test
	public void frequency() {
		int res = Iterables.frequency(list, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void partition() {
		Iterable<List<Integer>> res = Iterables.partition(list, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void size() {
		int res = Iterables.size(list);
		logger.debug("res={}", res);
	}

	@Test
	public void get() {
		Integer res = Iterables.get(list, 20, -1);
		logger.debug("res={}", res);
	}

	@Test
	public void getFirst() {
		Integer res = Iterables.getFirst(list, -1);
		logger.debug("res={}", res);
	}

	@Test
	public void getLast() {
		Integer res = Iterables.getLast(list, -1);
		logger.debug("res={}", res);
	}

	@Test
	public void limit() {
		Iterable<Integer> res = Iterables.limit(list, 3);
		logger.debug("res={}", res);
	}

	@Test
	public void getOnlyElement() {
		Integer res = Iterables.getOnlyElement(list, -1);
		logger.debug("res={}", res);
	}

	@Test
	public void unmodifiableIterable() {
		Iterable<Integer> res = Iterables.unmodifiableIterable(list);
		logger.debug("res={}", res);
	}

}

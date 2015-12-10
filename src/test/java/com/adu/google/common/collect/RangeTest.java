package com.adu.google.common.collect;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class RangeTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void open() {
		Range<Integer> res = Range.open(0, 10);
		logger.debug("res={}", res);
	}

	@Test
	public void closed() {
		Range<Integer> res = Range.closed(0, 10);
		logger.debug("res={}", res);
	}

	@Test
	public void greaterThan() {
		Range<Integer> res = Range.greaterThan(0);
		logger.debug("res={}", res);
	}

	@Test
	public void lessThan() {
		Range<Integer> res = Range.lessThan(0);
		logger.debug("res={}", res);
	}

	@Test
	public void atLeast() {
		Range<Integer> res = Range.atLeast(0);
		logger.debug("res={}", res);
	}

	@Test
	public void atMost() {
		Range<Integer> res = Range.atMost(0);
		logger.debug("res={}", res);
	}

	@Test
	public void all() {
		Range<Integer> res = Range.all();
		logger.debug("res={}", res);
	}

	@Test
	public void range() {
		Range<Integer> res = Range.range(0, BoundType.OPEN, 10, BoundType.OPEN);
		logger.debug("res={}", res);
	}

	@Test
	public void downTo() {
		Range<Integer> res = Range.downTo(0, BoundType.OPEN);
		logger.debug("res={}", res);
	}

	@Test
	public void upTo() {
		Range<Integer> res = Range.upTo(0, BoundType.OPEN);
		logger.debug("res={}", res);
	}

	@Test
	public void contains() {
		boolean res = Range.open(0, 10).contains(5);
		logger.debug("res={}", res);
	}

	@Test
	public void containsAll() {
		boolean res = Range.open(0, 10).containsAll(Ints.asList(1, 2, 4));
		logger.debug("res={}", res);
	}

	@Test
	public void lowerEndpoint() {
		Integer res = Range.open(0, 10).lowerEndpoint();
		logger.debug("res={}", res);
	}

	@Test
	public void intersection() {
		Range<Integer> res = Range.open(0, 10).intersection(Range.open(9, 20));
		logger.debug("res={}", res);
	}

	@Test
	public void span() {
		Range<Integer> res = Range.open(0, 10).span(Range.open(9, 20));
		logger.debug("res={}", res);
	}

}

package com.adu.google.common.collect.rangeSet;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class TreeRangeSetTest {
	private RangeSet<Integer> rangeSet;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void add() {
		rangeSet.add(Range.open(10, 15));
		rangeSet.add(Range.open(20, 25));
		logger.debug("rangeSet={}", rangeSet);
	}

	@Test
	public void remove() {
		rangeSet.remove(Range.open(3, 5));
		logger.debug("rangeSet={}", rangeSet);
	}

	@Test
	public void contains() {
		boolean res = rangeSet.contains(5);
		logger.debug("res={}", res);
	}

	@Test
	public void rangeContaining() {
		Range<Integer> res = rangeSet.rangeContaining(5);
		logger.debug("res={}", res);
	}

	@Test
	public void complement() {
		RangeSet<Integer> res = rangeSet.complement();
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.rangeSet = TreeRangeSet.create();
		this.rangeSet.add(Range.closed(0, 10));
	}

}

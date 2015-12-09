package com.adu.google.common.collect.rangeMap;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class TreeRangeMapTest {
	private RangeMap<Integer, String> rangeMap;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void subRangeMap() {
		RangeMap<Integer, String> res = rangeMap.subRangeMap(Range.closed(7, 15));
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.rangeMap = TreeRangeMap.create();
		this.rangeMap.put(Range.closed(0, 10), "a");
	}

}

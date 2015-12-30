package com.adu.utils;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class CollectionHelperTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void splitListByRate() {
		List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8");
		List<List<String>> res = CollectionHelper.splitListByRate(list, 3);
		logger.debug("res={}", res);
	}

}

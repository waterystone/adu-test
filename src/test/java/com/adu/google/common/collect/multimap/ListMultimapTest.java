package com.adu.google.common.collect.multimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class ListMultimapTest {
	private ListMultimap<String, String> multimap;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void size() {
		int res = multimap.size();
		logger.debug("res={}", res);
	}

	@Test
	public void asMap() {
		Map<String, Collection<String>> res = multimap.asMap();
		logger.debug("res={}", res);
	}

	@Test
	public void get() {
		List<String> res = multimap.get("b");
		logger.debug("res={}", res);
	}

	@Test
	public void remove() {
		boolean res = multimap.remove("b", "b2");
		logger.debug("res={}", res);
	}

	@Test
	public void removeAll() {
		List<String> res = multimap.removeAll("b");
		logger.debug("res={}", res);
	}

	@Test
	public void replaceValues() {
		List<String> res = multimap.replaceValues("b", Arrays.asList("b7", "b8"));
		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.multimap = ArrayListMultimap.create();
		this.multimap.put("a", "a1");

		this.multimap.put("b", "b1");
		this.multimap.put("b", "b2");

		this.multimap.put("c", "c1");
		this.multimap.put("c", "c1");
		this.multimap.put("c", "c3");
	}

}

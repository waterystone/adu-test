package com.adu.google.common.collect.multiset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

public class HashMultisetTest {
	private Multiset<String> multiset;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void size() {
		// 包含重复元素
		int res = multiset.size();
		logger.debug("res={}", res);
	}

	@Test
	public void iterator() {
		Iterator<String> iter = multiset.iterator();
		while (iter.hasNext()) {
			logger.debug(iter.next());
		}
	}

	@Test
	public void elementSet() {
		Set<String> res = multiset.elementSet();
		logger.debug("res={}", res);
	}

	@Test
	public void entrySet() {
		for (Entry<String> entry : multiset.entrySet()) {
			logger.debug(entry.getElement() + ":" + entry.getCount());
		}
	}

	@Test
	public void count() {
		int res = multiset.count("b");
		logger.debug("res={}", res);
	}

	@Test
	public void setCount() {
		// 返回set前的值
		int res = multiset.setCount("a", 10);
		logger.debug("res={},multiset={}", res, multiset);
	}

	@Test
	public void add() {
		boolean res = multiset.add("a");
		logger.debug("res={},multiset={}", res, multiset);
	}

	@Test
	public void add1() {
		// 返回add前的count
		int res = multiset.add("a", 2);
		logger.debug("res={},multiset={}", res, multiset);
	}

	@Test
	public void remove() {
		boolean res = multiset.remove("a");
		logger.debug("res={},multiset={}", res, multiset);
	}

	@Test
	public void remove1() {
		// remove过多会全部清除
		int res = multiset.remove("a", 2);
		logger.debug("res={},multiset={}", res, multiset);
	}

	@Before
	public void init() {
		this.multiset = HashMultiset.create(Arrays.asList("a", "b", "c", "b"));
	}

}

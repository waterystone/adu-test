package com.adu.google.common.collect;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class SetsTest {
	private Set<Integer> setA = ImmutableSet.of(1, 2, 3);
	private Set<Integer> setB = ImmutableSet.of(2, 3, 4);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void newHashSet() {
		Set<String> res = Sets.newHashSet();
		res.add("a");
		res.add("b");
		res.add("c");
		logger.debug("res={}", res);
	}

	@Test
	public void newConcurrentHashSet() {
		Set<String> res = Sets.newConcurrentHashSet();
		res.add("a");
		res.add("b");
		res.add("c");
		logger.debug("res={}", res);
	}

	@Test
	public void union() {
		SetView<Integer> res = Sets.union(setA, setB);
		logger.debug("res={}", res);
	}

	@Test
	public void intersection() {
		SetView<Integer> res = Sets.intersection(setA, setB);
		logger.debug("res={}", res);
	}

	@Test
	public void difference() {
		SetView<Integer> res = Sets.difference(setA, setB);
		logger.debug("res={}", res);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void cartesianProduct() {
		Set<List<Integer>> res = Sets.cartesianProduct(setA, setB);
		logger.debug("res={}", res);
	}

	@Test
	public void powerSet() {
		Set<Set<Integer>> res = Sets.powerSet(setA);
		logger.debug("res={}", res);
	}

}

package com.adu.google.common.primitives;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.primitives.Ints;

public class IntsTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void bytes() {
		int res = Ints.BYTES;
		logger.debug("res={}", res);
	}

	@Test
	public void toByteArray() {
		byte[] res = Ints.toByteArray(1);
		logger.debug("res={}", res);
	}

	@Test
	public void fromByteArray() {
		byte[] bytes = { 0, 0, 0, 2 };
		int res = Ints.fromByteArray(bytes);
		logger.debug("res={}", res);
	}

	@Test
	public void maxPoserOfTwo() {
		int res = Ints.MAX_POWER_OF_TWO;
		logger.debug("res={}", res);
	}

	@Test
	public void asList() {
		List<Integer> res = Ints.asList(1, 2, 3);
		logger.debug("res={}", res);
	}

	@Test
	public void toArray() {
		int[] res = Ints.toArray(Ints.asList(1, 2, 3));
		logger.debug("res={}", res);
	}

	@Test
	public void contains() {
		int[] arr = { 1, 2, 3 };
		boolean res = Ints.contains(arr, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void indexOf() {
		int[] arr = { 1, 2, 3 };
		int res = Ints.indexOf(arr, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void lastIndexOf() {
		int[] arr = { 1, 2, 3 };
		int res = Ints.lastIndexOf(arr, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void min() {
		int[] arr = { 1, 2, 3 };
		int res = Ints.min(arr);
		logger.debug("res={}", res);
	}

	@Test
	public void max() {
		int[] arr = { 1, 2, 3 };
		int res = Ints.max(arr);
		logger.debug("res={}", res);
	}

	@Test
	public void join() {
		int[] arr = { 1, 2, 3 };
		String res = Ints.join(",", arr);
		logger.debug("res={}", res);
	}

}

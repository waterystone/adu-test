package com.adu.concurrent;

import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ConcurrentLinkedQueueTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		Deque queue = new ConcurrentLinkedDeque<>();

	}

}

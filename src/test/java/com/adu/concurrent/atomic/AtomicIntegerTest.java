package com.adu.concurrent.atomic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class AtomicIntegerTest {
	private AtomicInteger atomic = new AtomicInteger();
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void get() {
		int res = atomic.get();
		logger.debug("res=" + res);

	}

}

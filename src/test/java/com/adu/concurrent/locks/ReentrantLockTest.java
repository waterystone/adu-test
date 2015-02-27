package com.adu.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ReentrantLockTest {
	private ReentrantLock lock = new ReentrantLock();
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() {
		lock.lock();
		try {
			// access the resource protected by this lock
		} finally {
			// 释放锁
			lock.unlock();
		}
		logger.debug("hello,world!");

	}

}

package com.adu.jdk.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ThreadTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void newTest() throws InterruptedException {
		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					logger.error("[ERROR-run]", e);
				}
			}
		};
		thread.start();
		thread.join();
		logger.debug("end");

	}

	@Test
	public void priority() {
		int res = Thread.MIN_PRIORITY;
		logger.debug("res=" + res);

	}

	@Test
	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("end");
	}

	@Test
	public void yield() {
		Thread.yield();
		logger.debug("end");
	}

	@Test
	public void waitTest() {
		Thread thread = new Thread();
		try {
			thread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("end");
	}

	@Test
	public void joinTest() {
		Thread thread = new Thread();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.debug("end");
	}

	@Test
	public void test() throws InterruptedException {
		final Generator generator = new Generator();

		Thread thread1 = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("[1-" + i + "]" + generator.getValue());
				}
			}
		};
		Thread thread2 = new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("[2-" + i + "]" + generator.getValue());
				}
			}
		};
		thread1.start();
		thread2.start();
		Thread.sleep(3000);
	}
}

class Generator {

	private int value = 1;

	public int getValue() {
		return value++;
	}
}

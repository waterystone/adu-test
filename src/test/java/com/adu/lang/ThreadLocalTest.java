package com.adu.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ThreadLocalTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws InterruptedException {
		Counter counter = new Counter();
		MyThread myThread1 = new MyThread(counter);
		MyThread myThread2 = new MyThread(counter);
		MyThread myThread3 = new MyThread(counter);
		myThread1.start();
		myThread2.start();
		myThread3.start();

		myThread1.join();
		myThread2.join();
		myThread3.join();

		logger.debug("end");
	}

	class Counter {
		private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
			public Integer initialValue() {
				return 0;
			}
		};

		public int incr() {
			counter.set(counter.get() + 1);
			return counter.get();
		}

	}

	class MyThread extends Thread {
		private Counter counter;

		public MyThread(Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				// ④每个线程打出3个序列值
				logger.debug("thread[" + Thread.currentThread().getName()
						+ "]counter=" + counter.incr());
			}
		}
	}
}

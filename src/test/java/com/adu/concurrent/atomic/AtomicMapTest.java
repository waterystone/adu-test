package com.adu.concurrent.atomic;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class AtomicMapTest {
	private AtomicMap map = new AtomicMap();
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		int count = 0;
		while (count++ < 100) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						map.addAndGet(i, 1);
					}
				}
			});
		}

		pool.shutdown();
		pool.awaitTermination(500, TimeUnit.SECONDS);

		Map<Integer, Integer> res = map.reset();
		for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
			logger.debug(entry.getKey() + "," + entry.getValue());
		}
	}
}

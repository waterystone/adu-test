package com.adu.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Test;

public class ExecutorServiceTest {
	private static final ExecutorService executor = Executors
			.newFixedThreadPool(10);
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void execute() throws InterruptedException {
		logger.debug("start");
		executor.execute(new Runnable() {
			@Override
			public void run() {
				RandomDataGenerator generator = new RandomDataGenerator();
				for (int i = 0; i < 10000; i++) {
					generator.nextBeta(23477272.20229847,
							234902902778.023740247);
				}
				logger.debug("hello");
			}
		});

		// 并不是终止线程的运行，而是禁止在这个Executor中添加新的任务.必须shutdown()才能awaitTermination(),否则awaitTermination()会一直等到timeout.而且shutdown()后。
		executor.shutdown();
		logger.debug("wait");
		executor.awaitTermination(10000, TimeUnit.SECONDS);
		logger.debug("end");
	}
}

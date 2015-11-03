package com.adu.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class FutureTest {
	private final ExecutorService executor = Executors.newFixedThreadPool(3);
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void get() throws InterruptedException, ExecutionException {
		MyTask task = new MyTask();
		Future<String> future = executor.submit(task);
		String res = future.get();
		logger.debug(res);
	}

	class MyTask implements Callable<String> {
		@Override
		public String call() throws Exception {
			Thread current = Thread.currentThread();
			return current.getId() + "," + current.getName();
		}

	}

}

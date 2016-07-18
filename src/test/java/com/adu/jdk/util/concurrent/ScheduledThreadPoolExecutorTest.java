package com.adu.jdk.util.concurrent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.adu.concurrent.ScheduledThreadPoolExecutorDemo;

public class ScheduledThreadPoolExecutorTest {

	private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
			10);

	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void schedule() {
		Runnable task = new ScheduleTask();
		executor.schedule(task, 3, TimeUnit.SECONDS);
		logger.debug("schedule end");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void scheduleAtFixedRate() {
		Runnable task = new ScheduleTask();
		executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
		logger.debug("schedule end");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void scheduleWithFixedDelay() {
		Runnable task = new ScheduleTask();
		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
		logger.debug("schedule end");
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ScheduleTask implements Runnable {
	private final Log logger = LogFactory
			.getLog(ScheduledThreadPoolExecutorDemo.class);

	public void run() {
		logger.debug("hello,world!");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("run end");
	}
}

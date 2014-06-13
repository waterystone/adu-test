package com.adu.utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TimerTest {

	public static Log logger = LogFactory.getLog(TimerTest.class);

	@Test
	public void schedule() throws InterruptedException {
		Timer timer = new Timer();
		long interval = 1 * 1000;

		// 每隔一段时间执行一次任务。如果间隔太短而任务执行时间太长，则会等任务执行完后再执行下一次的任务，不会并发执行多个任务。
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				logger.debug("hello,world!");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, new Date(), interval);

		Thread.sleep(1000000);
	}

}

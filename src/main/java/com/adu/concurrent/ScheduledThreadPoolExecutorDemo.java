package com.adu.concurrent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
				10);
		Runnable task = new Runnable() {

			public void run() {
				System.out.println("hello,world");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};

		executor.schedule(task, 0, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.MILLISECONDS);
		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.MILLISECONDS);

		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

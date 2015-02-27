package com.adu.concurrent.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ReentrantReadWriteLockTest {
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	private static Person person = new Person("David Beckham", true);
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws InterruptedException {
		new Thread() {
			public void run() {
				while (true) {
					try {
						lock.readLock().lock();
						System.out.print("name = " + person.getName());
						System.out.println(", isMan = " + person.isMan());
					} finally {
						lock.readLock().unlock();
					}
				}
			};
		}.start();

		new Thread() {
			public void run() {
				boolean state = true;
				while (true) {
					try {
						lock.writeLock().lock();
						if (state) {
							person.setName("Lady GaGa");
							person.setMan(false);
							state = false;
						} else {
							person.setName("David Beckham");
							person.setMan(true);
							state = true;
						}

					} finally {
						lock.writeLock().unlock();
					}
				}
			};
		}.start();

		Thread.sleep(3000);
		logger.debug("end~");
	}
}

class Person {
	private String name;
	private boolean isMan;

	public Person(String name, boolean isMan) {
		this.name = name;
		this.isMan = isMan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMan() {
		return isMan;
	}

	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}
}
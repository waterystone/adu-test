package com.adu.jdk.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class SynchronizedTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void test() throws InterruptedException {
		final Person person = new Person();
		Thread thread = new Thread() {
			@Override
			public void run() {
				person.set("adu", 27);
			}
		};
		thread.start();
		logger.debug("[1]" + person);

		Thread.sleep(3000);
		logger.debug("[2]" + person);

		thread.join();
		logger.debug("[3]" + person);
	}
}

class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public synchronized void set(String name, int age) {
		this.name = name;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.age = age;

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

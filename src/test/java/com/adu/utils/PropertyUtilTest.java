package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;

public class PropertyUtilTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void copyProperties() {
		Person orig = new Person("adu", 21);
		MyPerson dest = new MyPerson();
		PropertyUtil.copyProperties(orig, dest);

		logger.debug("dest={}", dest);
	}

	public static class MyPerson {
		private String name;
		private int sex;

		public MyPerson() {
			super();
		}

		public MyPerson(String name, int sex) {
			super();
			this.name = name;
			this.sex = sex;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSex() {
			return sex;
		}

		public void setSex(int sex) {
			this.sex = sex;
		}

		@Override
		public String toString() {
			return "MyPerson [name=" + name + ", sex=" + sex + "]";
		}

	}

}

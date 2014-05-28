package com.sohu.adrd.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class MapTest {
	private final Log logger = LogFactory.getLog(MapTest.class);

	@Test
	public void traverse() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.remove(2);
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	@Test
	public void get() {
		Person person1 = new Person(1, "test");
		Map<Person, String> map = new HashMap<Person, String>();
		map.put(person1, "hello,world");
		logger.debug(map.get(new Person(1, "test")));

	}

	class Person {
		private int id;
		private String name;

		public Person(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj instanceof Person) {
				return (this.id == ((Person) obj).id)
						&& (this.name.equals(((Person) obj).name));
			}
			return false;
		}

		@Override
		public int hashCode() {
			return this.toString().hashCode();
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + "]";
		}

	}

}

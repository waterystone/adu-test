package com.adu.jdk.util;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class SortedMapTest {
	private final Log logger = LogFactory.getLog(SortedMapTest.class);

	@Test
	public void test() {
		Person p1 = new Person(1, "a");
		Person p2 = new Person(2, "b");
		Person p3 = new Person(3, "c");
		Person p4 = new Person(3, "d");
		Comparator<Person> comparator = new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				if (o1.getId() == o2.getId()) {
					return 0;
				} else if (o1.getId() > o2.getId()) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		SortedMap<Person, Integer> map = new TreeMap<Person, Integer>(
				comparator);

		map.put(p3, p3.getId());
		map.put(p1, p1.getId());
		map.put(p2, p2.getId());
		map.put(p4, p4.getId());

		logger.debug(map);
		logger.debug(map.get(p4));

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

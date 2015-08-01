package com.adu.google.common.collect;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class ListsTest {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void newArrayList() {
		List<String> res = Lists.newArrayList("a", "b", "c");
		logger.debug(res);
	}

	@Test
	public void newLinkedList() {
		List<String> res = Lists.newLinkedList();
		res.add("a");
		res.add("b");
		res.add("c");
		logger.debug(res);
	}

	@Test
	public void newCopyOnWriteArrayList() {
		List<String> res = Lists.newCopyOnWriteArrayList();
		res.add("a");
		res.add("b");
		res.add("c");
		logger.debug(res);
	}

	@Test
	public void transform() {
		List<Person> persons = Lists.newArrayList();
		persons.add(new Person(1, "zhangsan"));
		persons.add(new Person(2, "lisi"));
		persons.add(new Person(3, "wangwu"));

		List<String> res = Lists.transform(persons, new Function<Person, String>() {

			@Override
			public String apply(Person input) {
				return input.getName();
			}

		});

		logger.debug("res=" + res);
	}

}

class Person {
	int id;
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
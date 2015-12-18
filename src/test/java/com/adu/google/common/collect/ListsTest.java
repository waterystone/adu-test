package com.adu.google.common.collect;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class ListsTest {
	private List<String> list;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void newArrayList() {
		logger.debug("list={}", list);
	}

	@Test
	public void newLinkedList() {
		list = Lists.newLinkedList();
		list.add("a");
		list.add("b");
		list.add("c");
		logger.debug("list={}", list);
	}

	@Test
	public void newCopyOnWriteArrayList() {
		list = Lists.newCopyOnWriteArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		logger.debug("list={}", list);
	}

	@Test
	public void partition() {
		List<List<String>> res = Lists.partition(list, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void reverse() {
		List<String> res = Lists.reverse(list);
		logger.debug("res={}", res);
	}

	@Test
	public void transform() {
		List<Person> persons = Lists.newArrayList();
		persons.add(new Person("zhangsan", 15));
		persons.add(new Person("lisi", 29));
		persons.add(new Person("wangwu", 23));

		List<String> res = Lists.transform(persons, new Function<Person, String>() {

			@Override
			public String apply(Person input) {
				return input.getName();
			}

		});
		res = Lists.newArrayList(res);
		res.add("adu");

		logger.debug("res={}", res);
	}

	@Before
	public void init() {
		this.list = Lists.newArrayList("a", "b", "c", "d", "e");
	}

}

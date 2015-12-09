package com.adu.google.common.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class OrderingTest {
	private List<Integer> list = new ArrayList<Integer>();
	private List<Person> persons = new ArrayList<Person>();
	private Ordering<Person> defaultOrdering;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void natural() {
		Ordering<Integer> ordering = Ordering.natural();
		Integer res = ordering.max(1, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void usingToString() {
		Ordering<Object> ordering = Ordering.usingToString();
		String res = ordering.max("ab", "aa");
		logger.debug("res={}", res);
	}

	@Test
	public void new1() {
		Ordering<Person> ordering = new Ordering<Person>() {

			@Override
			public int compare(Person left, Person right) {
				return left.getAge() - right.getAge();
			}
		};

		Person res = ordering.max(new Person("a", 1), new Person("b", 2));
		logger.debug("res={}", res);
	}

	@Test
	public void reverse() {
		Ordering<Integer> ordering = Ordering.natural().reverse();
		Integer res = ordering.max(1, 2);
		logger.debug("res={}", res);
	}

	@Test
	public void nullsFirst() {
		Ordering<Object> ordering = Ordering.usingToString().nullsFirst();
		String res = ordering.max(null, "a");
		logger.debug("res={}", res);
	}

	@Test
	public void nullsLast() {
		Ordering<Object> ordering = Ordering.usingToString().nullsLast();
		String res = ordering.max(null, "a");
		logger.debug("res={}", res);
	}

	@Test
	public void onResultOf() {
		// 排序链从后往前读
		Ordering<Person> ordering = Ordering.usingToString().nullsFirst().onResultOf(new Function<Person, String>() {

			@Override
			public String apply(Person input) {
				return input.getName();
			}

		});

		Person res = ordering.max(new Person("a", 1), new Person("b", 2));
		logger.debug("res={}", res);
	}

	@Test
	public void greatestOf() {
		List<Person> res = defaultOrdering.greatestOf(persons, 5);
		logger.debug("res={}", res);
	}

	@Test
	public void leastOf() {
		List<Person> res = defaultOrdering.leastOf(persons, 5);
		logger.debug("res={}", res);
	}

	@Test
	public void min() {
		Person res = defaultOrdering.min(persons);
		logger.debug("res={}", res);
	}

	@Test
	public void max() {
		Person res = defaultOrdering.max(persons);
		logger.debug("res={}", res);
	}

	@Test
	public void isOrdered() {
		boolean res = Ordering.natural().isOrdered(list);
		logger.debug("res={}", res);
	}

	@Test
	public void isStrictlyOrdered() {
		boolean res = Ordering.natural().isStrictlyOrdered(list);
		logger.debug("res={}", res);
	}

	@Test
	public void sortedCopy() {
		// 稳定排序、可重复、不影响输入、输出可变
		List<Person> res = defaultOrdering.sortedCopy(persons);
		logger.debug("size={},res={}", res.size(), res);
	}

	@Test
	public void immutableSortedCopy() {
		// 稳定排序、可重复、不影响输入、输出不可变
		List<Person> res = defaultOrdering.immutableSortedCopy(persons);

		logger.debug("size={},res={}", res.size(), res);
		res.add(null);
		logger.debug("end");
	}

	@Before
	public void init() {
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			int age = random.nextInt(100);
			persons.add(new Person("" + age, age));
			list.add(i);
		}

		defaultOrdering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, Integer>() {

			@Override
			public Integer apply(Person input) {
				return input.getAge();
			}

		});
	}

}

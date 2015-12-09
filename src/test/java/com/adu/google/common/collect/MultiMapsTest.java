package com.adu.google.common.collect;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

public class MultiMapsTest {
	private List<Person> persons = Lists.newArrayList(new Person("a", 11), new Person("b", 12), new Person("b", 17),
			new Person("c", 11));
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void index() {
		ImmutableListMultimap<String, Person> res = Multimaps.index(persons, new Function<Person, String>() {

			@Override
			public String apply(Person input) {
				return input.getName();
			}
		});
		logger.debug("res={}", res);
	}

	@Test
	public void forMap() {
		ImmutableMap<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 3);
		SetMultimap<String, Integer> res = Multimaps.forMap(map);
		logger.debug("map={},res={}", map, res);
	}

}

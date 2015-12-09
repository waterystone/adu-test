package com.adu.google.common.collect;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class MapsTest {
	private List<Person> persons = Lists.newArrayList(new Person("a", 11), new Person("b", 12), new Person("c", 11));
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void newHashMap() {
		Map<String, String> res = Maps.newHashMap();
		res.put("a", "1");
		res.put("b", "2");
		res.put("c", "3");
		logger.debug("res={}", res);
	}

	@Test
	public void newConcurrentMap() {
		Map<String, String> res = Maps.newConcurrentMap();
		res.put("a", "1");
		res.put("b", "2");
		res.put("c", "3");
		logger.debug("res={}", res);
	}

	@Test
	public void uniqueIndex() {

		Map<String, Person> res = Maps.uniqueIndex(persons, new Function<Person, String>() {

			@Override
			public String apply(Person input) {
				return input.getName();
			}
		});
		logger.debug("res={}", res);
	}

}

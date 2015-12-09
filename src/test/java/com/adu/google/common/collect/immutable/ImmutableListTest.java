package com.adu.google.common.collect.immutable;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * 集合不可变，但集合元素的属性不受控制。
 * 
 * @author yunjie.du
 * @date 2015年12月9日 下午2:46:17
 */
public class ImmutableListTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void of() {
		ImmutableList<Person> res = ImmutableList.of(new Person("a", 1), new Person("b", 2));
		logger.debug("res={}", res);
		Person person = res.get(0);
		person.setAge(10);
		logger.debug("res={}", res);
	}

	@Test
	public void copyOf() {
		List<String> list = Lists.newArrayList("a", "b", "c");

		ImmutableList<String> res = ImmutableList.copyOf(list);
		logger.debug("res={}", res);
	}

}

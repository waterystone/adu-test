package com.adu.alibaba.fastjson;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class JsonObjectTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void toStringTest() {
		JSONObject json = new JSONObject();
		json.put("date", new Date());
		String res = json.toString();
		logger.debug("res={}", res);
	}

	@Test
	public void toJSONString() {
		Person person = new Person("adu", 33);

		String res = JSONObject.toJSONString(person);
		logger.debug("res={}", res);
	}

	@Test
	public void toJSONString1() {
		List<Person> list = Lists.newArrayList(new Person("adu", 33), new Person("test", 22));

		String res = JSONObject.toJSONString(list);
		logger.debug("res={}", res);
	}

	@Test
	public void parseObject() {
		String str = "{\"age\":33,\"name\":\"adu\"}";

		Person res = JSONObject.parseObject(str, Person.class);
		logger.debug("res={}", res);
	}

	@Test
	public void parseArray() {
		String str = "[{\"age\":33,\"name\":\"adu\"},{\"age\":22,\"name\":\"test\"}]";

		List<Person> res = JSONObject.parseArray(str, Person.class);
		logger.debug("res={}", res);
	}

}

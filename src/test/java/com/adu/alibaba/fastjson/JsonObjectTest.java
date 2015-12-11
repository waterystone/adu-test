package com.adu.alibaba.fastjson;

import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.alibaba.fastjson.JSONObject;

public class JsonObjectTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void toJSONString() {
		JSONObject json = new JSONObject();
		json.put("date", new Date());
		String res = json.toJSONString();
		logger.debug("res={}", res);
	}

	@Test
	public void toJSONString1() {
		JSONObject json = new JSONObject();
		Person person = new Person("adu", 33);
		json.put("person", person);

		String res = json.toJSONString();
		logger.debug("res={}", res);
	}

}

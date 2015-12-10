package com.adu.utils;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.bean.JsonBean;

/**
 * @author: yunjie.du
 * @date: 2015/7/17 18:44
 */
public class JsonUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

	@Test
	public void string2Object() throws JAXBException {
		String json = "{\n" + "    \"ResultCode\": 0,\n" + "    \"Students\": [{\n" + "        \"id\": 1,\n"
				+ "        \"name\": \"zhangsan\",\n" + "        \"age\": 20\n" + "    },\n" + "    {\n"
				+ "        \"id\": 2,\n" + "        \"name\": \"lisi\",\n" + "        \"age\": 18\n" + "    }]\n" + "}";
		JsonBean res = JsonUtil.string2Object(json, JsonBean.class);
		logger.info(res.toString());
	}
}

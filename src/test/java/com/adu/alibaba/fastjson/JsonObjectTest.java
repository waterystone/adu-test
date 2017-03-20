package com.adu.alibaba.fastjson;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class JsonObjectTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void parse() {
		String str="[\"{\\\"messageId\\\":\\\"170313.092528.192.168.56.76.22448.1184916\\\",\\\"subject\\\":\\\"hotel" +
		 ".qta.order.core.sendsms.subject\\\",\\\"attrs\\\":{\\\"qmq_expireTime\\\":1489454728023," +
		  "\\\"ORDER_ID\\\":101109862517,\\\"qmq_appCode\\\":\\\"h_qta_orderbooking\\\",\\\"hotel.qta.order.core" +
		   ".sendsms.key\\\":\\\"{\\\\\\\"appId\\\\\\\":null,\\\\\\\"orderNo\\\\\\\":101109862517," +
		    "\\\\\\\"command\\\\\\\":\\\\\\\"USER_CONFIRMED\\\\\\\",\\\\\\\"phone\\\\\\\":\\\\\\\"150y=l_3936\\\\\\\"," +
		     "\\\\\\\"emailAddress\\\\\\\":null,\\\\\\\"forbidFilter\\\\\\\":false,\\\\\\\"param\\\\\\\":null," +
		      "\\\\\\\"resendOrder\\\\\\\":false,\\\\\\\"userSms\\\\\\\":true}\\\"," +
		       "\\\"qmq_createTIme\\\":1489368328023,\\\"qmq_spanId\\\":\\\"1.11.1.2.1.1.1.25.1.3.1\\\"," +
		        "\\\"VERSION\\\":18,\\\"COMMAND\\\":\\\"USER_CONFIRMED\\\"," +
		         "\\\"qmq_traceId\\\":\\\"qta-order-confirmq_170313.092527.192.168.52.229.2845.777638_1\\\"," +
		          "\\\"qmq_reliabilityLevel\\\":\\\"High\\\"},\\\"reliabilityLevel\\\":\\\"High\\\"," +
		           "\\\"createdTime\\\":\\\"2017-03-13 09:25:28\\\",\\\"expiredTime\\\":\\\"2017-03-14 09:25:28\\\"}\"]";
        String newStr=StringUtils.remove(str,"\\");
        newStr=StringUtils.replace(newStr,"\"{","{");
        newStr=StringUtils.replace(newStr,"}\"","}");
		Object res=JSONObject.parse(newStr);
		logger.debug("res={}", res);
	}

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

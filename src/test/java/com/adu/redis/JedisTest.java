package com.adu.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	private Jedis jedis;
	private String PREFIX_KEY = "YUNJIEDU:TEST:";
	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() {
		this.jedis = JedisUtil.getJedis();
	}

	@Test
	public void setex() {
		String key = PREFIX_KEY + "test";
		String value = "hello,world";
		String ret = this.jedis.setex(key, 3600, value);
		logger.debug("ret=" + ret);
	}

	@Test
	public void get() {
		String key = PREFIX_KEY + "test";
		String ret = this.jedis.get(key);
		logger.debug("ret=" + ret);
	}

	@Test
	public void ttl() {
		String key = "http://dealer.auto.sohu.com/bat67367/article_3202277.html";
		long ret = this.jedis.ttl(key);
		logger.debug("ret=" + ret);
	}

	@Test
	public void del() {
		String key = PREFIX_KEY + "test";
		Long ret = this.jedis.del(key);
		logger.debug("ret=" + ret);
	}
}

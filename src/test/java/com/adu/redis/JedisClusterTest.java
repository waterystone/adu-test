package com.adu.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.JedisCluster;

public class JedisClusterTest {
	private JedisCluster jedisCluster;
	private String PREFIX_KEY = "YUNJIEDU:TEST:";
	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() {
		this.jedisCluster = JedisClusterUtil.getCluster();
	}

	@Test
	public void setex() {
		String key = PREFIX_KEY + "test";
		String value = "hello,world";
		String ret = this.jedisCluster.setex(key, 3600, value);
		logger.debug("ret=" + ret);
	}

	@Test
	public void get() {
		String key = PREFIX_KEY + "test";
		for (int i = 0; i < 1; i++) {
			String ret = this.jedisCluster.get(key);
			logger.debug("ret=" + ret);
		}
	}

	@Test
	public void del() {
		String key = PREFIX_KEY + "test";
		Long ret = this.jedisCluster.del(key);
		logger.debug("ret=" + ret);
	}
}

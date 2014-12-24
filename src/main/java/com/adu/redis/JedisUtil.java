package com.adu.redis;

import redis.clients.jedis.Jedis;

public class JedisUtil {
	private static Jedis jedis;
	static {
		// jedis = new Jedis("10.10.125.93", 22122);
		// jedis = new Jedis("10.16.34.17", 22121);
		jedis = new Jedis("10.16.3.4", 22121);
	}

	public static Jedis getJedis() {
		return jedis;
	}
}

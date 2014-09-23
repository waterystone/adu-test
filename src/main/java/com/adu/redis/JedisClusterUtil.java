package com.adu.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterUtil {
	private static JedisCluster jedisCluster;
	static {
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("10.16.34.71", 6380));
		jedisClusterNodes.add(new HostAndPort("10.16.34.72", 6380));
		jedisClusterNodes.add(new HostAndPort("10.16.34.73", 6380));
		jedisClusterNodes.add(new HostAndPort("10.16.34.74", 6380));
		jedisClusterNodes.add(new HostAndPort("10.16.34.75", 6380));
		jedisCluster = new JedisCluster(jedisClusterNodes);
	}

	public static JedisCluster getCluster() {
		return jedisCluster;
	}
}

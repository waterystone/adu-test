package com.adu.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterUtil {
	private static JedisCluster jedisCluster;
	static {
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		// jedisClusterNodes.add(new HostAndPort("10.16.34.71", 6380));
		// jedisClusterNodes.add(new HostAndPort("10.16.34.72", 6380));
		// jedisClusterNodes.add(new HostAndPort("10.16.34.73", 6380));
		// jedisClusterNodes.add(new HostAndPort("10.16.34.74", 6380));
		// jedisClusterNodes.add(new HostAndPort("10.16.34.75", 6380));

		jedisClusterNodes.add(new HostAndPort("10.16.34.16", 22121));
		jedisClusterNodes.add(new HostAndPort("10.16.34.17", 22121));
		jedisClusterNodes.add(new HostAndPort("10.16.34.18", 22121));
		jedisClusterNodes.add(new HostAndPort("10.16.34.19", 22121));
		jedisClusterNodes.add(new HostAndPort("10.16.34.20", 22121));

		// jedisClusterNodes.add(new HostAndPort("10.16.10.42", 22121));
		// jedisClusterNodes.add(new HostAndPort("10.16.10.42", 22122));
		// jedisClusterNodes.add(new HostAndPort("10.16.43.144", 22121));
		// jedisClusterNodes.add(new HostAndPort("10.16.43.144", 22122));
		// jedisClusterNodes.add(new HostAndPort("10.16.43.144", 22123));
		jedisCluster = new JedisCluster(jedisClusterNodes);
	}

	public static JedisCluster getCluster() {
		return jedisCluster;
	}
}

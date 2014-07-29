package com.adu.kafka;

import java.util.List;

import kafka.cluster.Broker;

import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KafkaUtilTest {
	private static final String zkHosts = "10.10.76.102:2181,10.10.76.103:2181,10.10.76.104:2181";
	private static final String topic = "wcms.news.topic";
	private ZkClient zkClient;
	private final Log logger = LogFactory.getLog(this.getClass());

	@Before
	public void init() {
		zkClient = new ZkClient(zkHosts, 6000000, 6000000,
				new ZkStringSerializer());
	}

	@After
	public void destory() {
		if (zkClient != null) {
			zkClient.close();
		}
	}

	@Test
	public void getAllBrokersInCluster() throws Exception {
		List<Broker> brokers = KafkaUtil.getAllBrokersInCluster(zkClient);

		for (Broker broker : brokers) {
			logger.debug(broker);
		}

	}

}

package com.adu.kafka;

import java.util.List;

import kafka.api.FetchRequest;
import kafka.api.FetchRequestBuilder;
import kafka.javaapi.FetchResponse;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.javaapi.message.ByteBufferMessageSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleConsumerTest {
	private final Log logger = LogFactory.getLog(this.getClass());
	private String topic = "CmsSourceTest";//
	private int partition = 0;
	private String host = "10.10.68.186";
	private int port = 8093;
	private String clientId = "SimpleConsumerDemoClient";

	private SimpleConsumer consumer;

	@Before
	public void init() {
		consumer = new SimpleConsumer(host, port, 100000, 65536, clientId);
	}

	@After
	public void destory() {
		if (consumer != null) {
			consumer.close();
		}
	}

	@Test
	public void test() {
		long time = System.currentTimeMillis() - 200000;
		long offset = KafkaUtil.getOffset(consumer, topic, partition, time,
				clientId);
		logger.debug("offset=" + offset);
		FetchRequest fetechRequst = new FetchRequestBuilder()
				.clientId(clientId).addFetch(topic, partition, offset, 819200)
				.build();
		FetchResponse response = consumer.fetch(fetechRequst);
		ByteBufferMessageSet messageSet = response.messageSet(topic, partition);
		List<String> messages = KafkaUtil.getMessages(messageSet);
		for (String message : messages) {
			logger.debug(message);
		}
	}

}

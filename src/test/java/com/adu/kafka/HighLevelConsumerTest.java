package com.adu.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class HighLevelConsumerTest {
	private String topic = "xxx";
	private ConsumerConnector consumer;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before
	public void init() {
		Properties props = new Properties();

		props.put("zookeeper.connect", "zk.dev.corp.xxx.com:2181/qhstatsdev");
		props.put("zookeeper.connection.timeout.ms", "20000");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("group.id", "des-yunjie.du-test");
		props.put("auto.offset.reset", "smallest");// 直接从当前开始读取
		ConsumerConfig conf = new ConsumerConfig(props);

		consumer = kafka.consumer.Consumer.createJavaConsumerConnector(conf);
	}

	@Test
	public void consume() {
		try {
			// key为topic,value为该topic开辟的流的个数
			Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
			topicCountMap.put(topic, 1);// 在实际应用中需要为每个topic开辟多个流，一般与partation的个数相同，不能大于partation的个数！！

			Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
			KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);// 获取该topic对应的流。当流列表中流有多个时，需要为每个流开辟一个线程进行并行处理，否则只有第一个流能行到处理！！！

			ConsumerIterator<byte[], byte[]> iter = stream.iterator();
			while (iter.hasNext()) {
				MessageAndMetadata<byte[], byte[]> messageAndMetadata = iter.next();
				String message = getMessage(messageAndMetadata);// 获取一条原始日志信息
				logger.debug("message=" + message);

			}
		} catch (Exception e) {
			logger.error("[ERROR-start]", e);
		}
	}

	private String getMessage(MessageAndMetadata<byte[], byte[]> messageAndMetadata) {
		String res = null;
		if (messageAndMetadata == null) {
			return res;
		}
		try {
			byte[] message = messageAndMetadata.message();
			if (message == null) {
				return res;
			}

			// 解码
			res = new String(message, "UTF-8");
		} catch (Exception e) {
			logger.error("[ERROR-getMessage]messageAndMetadata=" + messageAndMetadata, e);
		}
		return res;

	}
}

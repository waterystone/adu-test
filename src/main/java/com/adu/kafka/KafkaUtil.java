package com.adu.kafka;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kafka.cluster.Broker;
import kafka.common.ErrorMapping;
import kafka.common.TopicAndPartition;
import kafka.javaapi.OffsetResponse;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.javaapi.message.ByteBufferMessageSet;
import kafka.message.MessageAndOffset;
import kafka.utils.ZkUtils;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaUtil {
	protected static final Logger logger = LoggerFactory
			.getLogger(KafkaUtil.class);

	/**
	 * 获取该zk所维护的broker列表
	 * 
	 * @param zkClient
	 * @return
	 * @throws Exception
	 */
	public static List<Broker> getAllBrokersInCluster(ZkClient zkClient)
			throws Exception {
		List<Broker> res = new ArrayList<Broker>();
		ComparatorString cpm = new ComparatorString();
		try {

			// 获取brokerId列表
			List<String> brokerIds = zkClient.getChildren(ZkUtils
					.BrokerIdsPath());

			// 排序
			Collections.sort(brokerIds, cpm);

			// 根据brokerId获取broker对象
			for (String brokerId : brokerIds) {
				if (ZkUtils.getBrokerInfo(zkClient, Integer.parseInt(brokerId))
						.isDefined()) {
					res.add(ZkUtils.getBrokerInfo(zkClient,
							Integer.parseInt(brokerId)).get());
				}
			}
		} catch (Exception e) {
			logger.error("[ERROR-getAllBrokersInCluster]zkClient=" + zkClient,
					e);
		}
		return res;
	}

	public static void createEphemeralPathExpectConflictHandleZKBug(
			ZkClient zkClient, String path, String data,
			Object expectedCallerData, int backoffTime) throws Exception {
		while (true) {
			try {
				ZkUtils.createEphemeralPathExpectConflict(zkClient, path, data);
				return;
			} catch (Exception e) {
				throw e;
			}
		}
	}

	private static void createParentPath(ZkClient client, String path) {
		String parentDir = path.substring(0, path.lastIndexOf('/'));
		if (parentDir.length() != 0) {
			client.createPersistent(parentDir, true);
		}
	}

	public static void updatePersistentPath(ZkClient client, String path,
			String data) throws Exception {
		try {
			client.writeData(path, data);
		} catch (ZkNoNodeException e) {
			createParentPath(client, path);
			try {
				client.createPersistent(path, data);
			} catch (ZkNodeExistsException e1) {
				client.writeData(path, data);
			} catch (Exception e2) {
				throw e2;
			}
		} catch (Exception e3) {
			throw e3;
		}
	}

	public static List<String> getChildrenParentMayNotExist(ZkClient client,
			String path) throws Exception {
		try {
			return client.getChildren(path);
		} catch (ZkNoNodeException e) {
			logger.error(" getChildrenParentMayNotExist " + e);
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 获取该client在相应partition上的offset
	 * 
	 * @param consumer
	 * @param topic
	 * @param partition
	 * @param whichTime
	 *            -2表示最早的(即最小的offset)；-1表示最后的(即最大的offset)
	 * @param clientName
	 * @return
	 */
	public static long getOffset(SimpleConsumer consumer, String topic,
			int partition, long whichTime, String clientName) {
		TopicAndPartition topicAndPartition = new TopicAndPartition(topic,
				partition);
		Map<TopicAndPartition, kafka.api.PartitionOffsetRequestInfo> requestInfo = new HashMap<TopicAndPartition, kafka.api.PartitionOffsetRequestInfo>();
		requestInfo.put(topicAndPartition,
				new kafka.api.PartitionOffsetRequestInfo(whichTime, 1));

		kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(
				requestInfo, kafka.api.OffsetRequest.CurrentVersion(),
				clientName);
		OffsetResponse response = consumer.getOffsetsBefore(request);

		if (response.hasError()) {
			logger.error("[ERROR-getOffset]Reason: "
					+ ErrorMapping.exceptionFor(response.errorCode(topic,
							partition)));
			return 0;
		}
		long[] offsets = response.offsets(topic, partition);
		return offsets[0];
	}

	public static List<String> getMessages(ByteBufferMessageSet messageSet) {
		List<String> res = new ArrayList<String>();
		if (messageSet == null) {
			return res;
		}

		try {
			Iterator<MessageAndOffset> messageIter = messageSet.iterator();
			while (messageIter.hasNext()) {
				// 获取一条消息
				MessageAndOffset messageAndOffset = messageIter.next();

				String messageStr = getMessage(messageAndOffset);
				if (messageStr != null) {
					res.add(messageStr);
				}
			}
		} catch (Exception e) {
			logger.error("[ERROR-getMessages]", e);
		}
		return res;
	}

	/**
	 * 从MessageAndOffset对象中获取存储的消息
	 * 
	 * @param messageAndOffset
	 * @return
	 */
	public static String getMessage(MessageAndOffset messageAndOffset) {
		String res = null;
		if (messageAndOffset == null) {
			return res;
		}
		try {
			ByteBuffer payload = messageAndOffset.message().payload();
			if (payload == null) {
				return res;
			}

			byte[] bytes = new byte[payload.limit()];
			payload.get(bytes);

			// 解码
			res = new String(bytes, "UTF-8");
		} catch (Exception e) {
			logger.error("[ERROR-getMessage]", e);
		}
		return res;
	}

}

class ComparatorString implements Comparator<String> {

	public int compare(String arg0, String arg1) {
		return (arg0.compareTo(arg1));
	}

}

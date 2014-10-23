package com.adu.org.apache.zookeeper;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZooKeeperTest {
	private ZooKeeper zooKeeper;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private final Log logger = LogFactory.getLog(this.getClass());

	@Test
	public void setData() throws KeeperException, InterruptedException {
		init();
		String data = "hello,world!";
		byte[] bytes = data.getBytes();
		zooKeeper.setData("/adu", bytes, -1);

	}

	@Test
	public void getData() throws KeeperException, InterruptedException {
		init();
		Stat stat = new Stat();
		byte[] res = zooKeeper.getData("/adu/test", false, stat);
		logger.debug("res=" + new String(res));

	}

	private void sleep() {
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
		}

	}

	private void init() {
		Watcher watcher = new Watcher() {

			public void process(WatchedEvent event) {
				logger.debug("[watcher]event=" + event);

			}
		};
		try {
			zooKeeper = new ZooKeeper("10.16.10.66:2181", 600000, watcher);
		} catch (IOException e) {
			logger.error("[ERROR-ZooKeeper]", e);
		}
	}

}

package com.adu.org.apache.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

public class ZooKeeperTest extends BaseTest {
    private ZooKeeper zooKeeper;

    @Test
    public void setData() throws KeeperException, InterruptedException {
        String data = "hello,world!";
        byte[] bytes = data.getBytes();
        zooKeeper.setData("/adu", bytes, -1);

    }

    @Test
    public void getData() throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte[] res = zooKeeper.getData("/test", false, stat);
        logger.info("res={}", new String(res));

    }

    private void sleep() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
        }

    }

    @Before
    public void init() {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                logger.debug("[watcher]event={}", watchedEvent);
            }
        };

        try {
            zooKeeper = new ZooKeeper("10.86.42.140:2181", 600000, watcher);
        } catch (IOException e) {
            logger.error("[ERROR-ZooKeeper]", e);
        }
    }

}

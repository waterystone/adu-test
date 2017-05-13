package com.adu.org.apache.zookeeper;

import java.text.SimpleDateFormat;
import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

public class ZkClientTest extends BaseTest {
    private ZkClient zkClient;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void createPersistent() {
        try {
            String res = zkClient.create("/adu/test", 7, CreateMode.PERSISTENT);
            logger.debug("res=" + res);
        } catch (Exception e) {
            logger.error("[ERROR-createPersistent]", e);
        }

    }

    @Test
    public void createPersistentSequential() {
        try {
            String res = zkClient.create("/adu/test", 7, CreateMode.PERSISTENT_SEQUENTIAL);
            logger.debug("res=" + res);

            res = zkClient.create("/adu/test", 7, CreateMode.PERSISTENT_SEQUENTIAL);
            logger.debug("res=" + res);

            res = zkClient.create("/adu/test", 7, CreateMode.PERSISTENT_SEQUENTIAL);
            logger.debug("res=" + res);
        } catch (Exception e) {
            logger.error("[ERROR-createPersistentSequential]", e);
        }

    }

    @Test
    public void createEphemeral() {
        try {
            String res = zkClient.create("/adu/test", 7, CreateMode.EPHEMERAL);
            logger.debug("res=" + res);
            sleep();
        } catch (Exception e) {
            logger.error("[ERROR-createPersistent]", e);
        }

    }

    @Test
    public void createEphemeralSequential() {
        try {
            String res = zkClient.create("/adu/test", 7, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.debug("res=" + res);

            res = zkClient.create("/adu/test", 7, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.debug("res=" + res);

            res = zkClient.create("/adu/test", 7, CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.debug("res=" + res);
            sleep();
        } catch (Exception e) {
            logger.error("[ERROR-createPersistent]", e);
        }

    }

    @Test
    public void delete() {
        boolean res = zkClient.delete("/adu/test");
        logger.debug("res=" + res);
    }

    @Test
    public void deleteRecursive() {
        boolean res = zkClient.deleteRecursive("/adu");
        logger.debug("res=" + res);
    }

    @Test
    public void exists() {
        boolean res = zkClient.exists("/adu");
        logger.debug("res=" + res);
    }

    @Test
    public void countChildren() {
        int res = zkClient.countChildren("/adu");
        logger.debug("res=" + res);
    }

    @Test
    public void getChildren() {
        List<String> res = zkClient.getChildren("/adu");
        logger.debug("res=" + res);
    }

    @Test
    public void getCreationTime() {
        long res = zkClient.getCreationTime("/adu");
        logger.debug("res=" + simpleDateFormat.format(res));
    }

    @Test
    public void readData() {
        Object res = zkClient.readData("/adu/test");
        logger.debug("res=" + res);
    }

    @Test
    public void readData1() {
        Object res = zkClient.readData("/adu1", true);
        logger.debug("res=" + res);
    }

    @Test
    public void readData2() {
        Stat stat = new Stat();
        Object res = zkClient.readData("/adu", stat);
        logger.debug("res=" + res + ",stat=" + stat);
    }

    @Test
    public void writeData() {
        zkClient.writeData("/adu", 7);
    }

    @Test
    public void writeData1() {
        Stat stat = new Stat();
        Object res = zkClient.readData("/adu", stat);

        zkClient.writeData("/adu", 7, stat.getVersion());
        logger.debug("res=" + res);
    }

    @Test
    public void writeDataReturnStat() {
        Stat stat = new Stat();
        Object res = zkClient.readData("/adu", stat);

        Stat newStat = zkClient.writeDataReturnStat("/adu", 7, stat.getVersion());

        logger.debug("res=" + res);
        logger.debug("stat=" + stat);
        logger.debug("newStat=" + newStat);
    }

    @Test
    public void subscribeDataChanges() {
        IZkDataListener listener = new IZkDataListener() {

            public void handleDataDeleted(String dataPath) throws Exception {
                logger.debug("[data-delete]path=" + dataPath);

            }

            public void handleDataChange(String dataPath, Object data) throws Exception {
                logger.debug("[data-change]path=" + dataPath + ",data=" + data);

            }
        };
        zkClient.subscribeDataChanges("/adu", listener);
        sleep();
    }

    @Test
    public void subscribeChildChanges() {
        IZkChildListener listener = new IZkChildListener() {

            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                logger.debug("currentChilds=" + currentChilds);

            }
        };
        List<String> res = zkClient.subscribeChildChanges("/adu", listener);
        logger.debug("res=" + res);
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
        }

    }

    @Before
    public void init() {
        zkClient = new ZkClient("10.86.42.140:2181", 6000000, 6000000);
    }

}

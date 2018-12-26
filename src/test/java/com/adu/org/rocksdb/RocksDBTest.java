package com.adu.org.rocksdb;

import com.adu.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

/**
 * @author duyunjie
 * @date 2018-12-25 19:59
 */
public class RocksDBTest extends BaseTest {
    private RocksDB rocksDB;

    @Test
    public void put() throws RocksDBException {
        String key = "hello";
        byte[] keyBytes = key.getBytes();

        String value = "world";
        byte[] valueBytes = value.getBytes();

        rocksDB.put(keyBytes, valueBytes);

        byte[] newValueBytes = rocksDB.get(keyBytes);
        String res = new String(newValueBytes);
        logRes(res);
    }

    @Test
    public void get() throws RocksDBException {
        String key = "hello";
        byte[] keyBytes = key.getBytes();

        byte[] valueBytes = rocksDB.get(keyBytes);
        String res = new String(valueBytes);
        logRes(res);
    }

    @Before
    public void init() {
        // a static method that loads the RocksDB C++ library.
        RocksDB.loadLibrary();

        // the Options class contains a set of configurable DB options
        // that determines the behaviour of the database.
        try {
            final Options options = new Options().setCreateIfMissing(true);
            rocksDB = RocksDB.open(options, "/Users/yunjie.du/data/rocksdb/test");
        } catch (RocksDBException e) {
            logger.error("[ERROR-init]", e);
        }
    }
}

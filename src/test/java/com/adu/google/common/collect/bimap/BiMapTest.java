package com.adu.google.common.collect.bimap;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {
    private BiMap<String, String> bimap;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void size() {
        int res = bimap.size();
        logger.debug("res={}", res);
    }

    @Test
    public void get() {
        String res = bimap.get("b");
        logger.debug("res={}", res);
    }

    @Test
    public void put() {
        String res = bimap.put("a", "2");
        logger.debug("res={}", res);
    }

    @Test
    public void forcePut() {
        String res = bimap.forcePut("a", "2");
        logger.debug("res={},bimap={}", res, bimap);
    }

    @Test
    public void remove() {
        String res = bimap.remove("b");
        logger.debug("res={}", res);
    }

    @Test
    public void inverse() {
        BiMap<String, String> res = bimap.inverse();
        logger.debug("res={}", res);
    }

    @Test
    public void containsValue() {
        boolean res = bimap.containsValue("1");
        logger.debug("res={}", res);
    }

    @Before
    public void init() {
        this.bimap = HashBiMap.create();
        this.bimap.put("a", "1");
        this.bimap.put("b", "2");
        this.bimap.put("c", "3");

    }

}

package com.adu.org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MutablePairTest {
    MutablePair<String, Integer> pair = MutablePair.of("abc", 123);
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void of() {
        MutablePair<String, Integer> res = MutablePair.of("abc", 123);
        logger.debug("res={}", res);
    }

    @Test
    public void new1() {
        MutablePair<String, Integer> res = new MutablePair<>("abc", 123);
        logger.debug("res={}", res);
    }


    @Test
    public void setLeft() {
        pair.setLeft("adu");
        logger.debug("pair={}", pair);
    }

    @Test
    public void setRight() {
        pair.setRight(1);
        logger.debug("pair={}", pair);
    }

    @Test
    public void setValue() {
        Integer oldValue = pair.setValue(1);
        logger.debug("pair={},oldValue={}", pair, oldValue);
    }

}

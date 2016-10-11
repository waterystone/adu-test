package com.adu.org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImmutablePairTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void of() {
        ImmutablePair<String, Integer> res = ImmutablePair.of("abc", 123);
        logger.debug("res={}", res);
    }

    @Test
    public void new1() {
        ImmutablePair<String, Integer> res = new ImmutablePair<>("abc", 123);
        logger.debug("res={}", res);
    }

}

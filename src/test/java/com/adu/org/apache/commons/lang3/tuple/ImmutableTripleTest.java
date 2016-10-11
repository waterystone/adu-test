package com.adu.org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImmutableTripleTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void of() {
        ImmutableTriple<Integer, String, String> res = ImmutableTriple.of(1, "adu", "Male");
        logger.debug("res={}", res);
    }

    @Test
    public void new1() {
        ImmutableTriple<Integer, String, String> res = new ImmutableTriple<>(1, "adu", "Male");
        logger.debug("res={}", res);
    }

}

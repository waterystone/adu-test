package com.adu.org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.MutableTriple;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MutableTripleTest {
    MutableTriple<Integer, String, String> triple = MutableTriple.of(1, "adu", "Male");
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void of() {
        MutableTriple<Integer, String, String> res = MutableTriple.of(1, "adu", "Male");
        logger.debug("res={}", res);
    }

    @Test
    public void new1() {
        MutableTriple<Integer, String, String> res = new MutableTriple<>(1, "adu", "Male");
        logger.debug("res={}", res);
    }

    @Test
    public void setLeft() {
        triple.setLeft(2);
        logger.debug("triple={}", triple);
    }

    @Test
    public void setRight() {
        triple.setMiddle("aduadu");
        logger.debug("triple={}", triple);
    }

    @Test
    public void setValue() {
        triple.setRight("Female");
        logger.debug("triple={}", triple);
    }

}

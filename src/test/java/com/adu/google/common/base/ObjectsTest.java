package com.adu.google.common.base;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.google.common.base.Objects;

public class ObjectsTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void equal() {
        String a = new String("a"), b = new String("a");
        boolean res = Objects.equal(a, b);
        logger.debug("a==b:{}", a == b);
        logger.debug("res={}", res);
    }

    @Test
    public void hashCodeTest() {
        Person person = new Person("adu", 28);
        int res = Objects.hashCode(person);
        logger.debug("res={}", res);
    }

    @Test
    public void firstNonNullTest() {
        String a = null, b = "adu";
        String res = Objects.firstNonNull(a, b);
        logRes(res);
    }

}

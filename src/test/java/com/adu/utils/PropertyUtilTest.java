package com.adu.utils;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.MyPerson;
import com.adu.model.Person;

public class PropertyUtilTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void copyProperties() {
        Person orig = new Person("adu", 21);
        MyPerson dest = new MyPerson();
        PropertyUtil.copyProperties(orig, dest);

        logger.debug("dest={}", dest);
    }

}

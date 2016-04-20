package com.adu.utils;

import com.adu.model.Person;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReflectUtilTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void fillDefaultValue() {
        Person person = new Person();
        ReflectUtil.fillDefaultValue(person);
        logger.debug("person={}", person);
    }

}

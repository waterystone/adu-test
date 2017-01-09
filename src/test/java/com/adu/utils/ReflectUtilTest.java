package com.adu.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.model.Person;

public class ReflectUtilTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getFieldValue() {
        Person person = new Person("adu", 21);
        String res = ReflectUtil.getFieldValue(person, "name");
        logger.debug("res={}", res);
    }

    @Test
    public void setFieldValue() {
        Person person = new Person("adu", 21);
        ReflectUtil.setFieldValue(person, "name", "test");
        logger.debug("person={}", person);
    }

    @Test
    public void fillDefaultValue() {
        Person person = new Person();
        ReflectUtil.fillDefaultValue(person);
        logger.debug("person={}", person);
    }

}

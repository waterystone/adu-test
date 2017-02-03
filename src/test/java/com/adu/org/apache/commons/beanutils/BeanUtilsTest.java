package com.adu.org.apache.commons.beanutils;

import com.adu.model.MyPerson;
import com.adu.model.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BeanUtilsTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void cloneBean() throws Exception {
        Person person = new Person("adu", 21);
        Person res = (Person) BeanUtils.cloneBean(person);
        logger.debug("res={}", res);
    }

    @Test
    public void copyProperties() throws Exception {
        Person person = new Person("adu", 21);
        MyPerson res = new MyPerson();

        BeanUtils.copyProperties(res, person);
        logger.debug("res={}", res);
    }

    @Test
    public void describe() throws Exception {
        Person person = new Person("adu", 21);
        Map res = BeanUtils.describe(person);
        logger.debug("res={}", res);
    }

}

package com.adu.utils;

import java.util.Date;

import com.adu.model.SubObject;
import org.joda.time.DateTime;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.MyPerson;
import com.adu.model.Person;

/**
 * @author yunjie.du
 * @date 2016/12/22 16:09
 */
public class BeanUtilTest extends BaseTest {

    @Test
    public void cloneBean() throws Exception {
        Person person = new Person("adu", 21, new DateTime(), new Date(),new SubObject("test"));
        MyPerson res = BeanUtil.cloneBean(person, MyPerson.class);
        logger.debug("res={}", res);
    }

    @Test
    public void copyProperties() throws Exception {
        Person person = new Person("adu", 21, new DateTime());
        MyPerson res = new MyPerson();

        BeanUtil.copyProperties(person, res);
        logger.debug("res={}", res);
    }
}

package com.adu.model;

import java.util.Date;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/3/20 10:53
 */
public class PersonTest extends BaseTest {
    @Test
    public void hashCodeTest() {
        Person person = new Person("adu", 11);
        int hashCode1 = person.hashCode();
        person.setBirthDate(new Date());
        int hashCode2 = person.hashCode();

        logger.info("hashCode1={},hashCode2={}", hashCode1, hashCode2);
    }
}

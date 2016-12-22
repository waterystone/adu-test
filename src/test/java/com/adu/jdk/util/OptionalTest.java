package com.adu.jdk.util;

import java.util.Optional;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author yunjie.du
 * @date 2016/12/20 15:34
 */
public class OptionalTest extends BaseTest {
    private Optional<Person> optional = Optional.of(new Person("adu", 27));

    @Test
    public void isPresent() {
        optional = Optional.empty();
        boolean res = optional.isPresent();
        logger.info("res={}", res);
    }

    @Test
    public void get() {
        Person res = optional.get();
        logger.info("res={}", res);
    }

    @Test
    public void empty() {
        Optional res = Optional.empty();
        boolean isPresent = res.isPresent();
        logger.info("res={},isPresent={}", res, isPresent);
    }
}

package com.adu.org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author duyunjie
 * @date 2019-12-12 15:13
 */
public class LazyInitializerTest extends BaseTest {
    private static final LazyInitializer<Person> LAZY_PERSON = new LazyInitializer<Person>() {
        @Override
        protected Person initialize() throws ConcurrentException {
            System.out.println("op=start_initialize");
            return new Person("adu", 18);
        }
    };

    @Test
    public void test() throws ConcurrentException {
        for (int i = 0; i < 10; i++) {
            logger.info("[{}]person={}", i, LAZY_PERSON.get());
        }

    }
}

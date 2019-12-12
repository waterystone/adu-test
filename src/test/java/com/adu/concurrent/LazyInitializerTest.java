package com.adu.concurrent;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

public class LazyInitializerTest extends BaseTest {
    private static final LazyInitializer<Person> LAZY_PERSON = new LazyInitializer<Person>() {
        @Override
        protected Person initialize() {
            System.out.println("op=start_initialize");
            return new Person("adu", 18);
        }
    };

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            logger.info("[{}]person={}", i, LAZY_PERSON.get());
        }

    }
}
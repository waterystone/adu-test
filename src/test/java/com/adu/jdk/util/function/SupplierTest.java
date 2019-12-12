package com.adu.jdk.util.function;

import java.util.function.Supplier;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author duyunjie
 * @date 2019-12-12 14:53
 */
public class SupplierTest extends BaseTest {
    private Supplier<Person> personSupplier = () -> {
        logger.info("op=start_create_person");
        return new Person("adu", 18);
    };

    @Test
    public void name() {
        for (int i = 0; i < 10; i++) {
            logger.info("[{}]person={}", i, personSupplier.get());
        }

    }

}

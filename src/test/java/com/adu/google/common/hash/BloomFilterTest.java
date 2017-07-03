package com.adu.google.common.hash;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

/**
 * @author yunjie.du
 * @date 2017/6/30 15:11
 */
public class BloomFilterTest extends BaseTest {
    private static final int PERSON_COUNT = 1000000;
    private BloomFilter<Person> bloomFilter;

    @Test
    public void mightContain() {
        boolean res = this.bloomFilter.mightContain(new Person("101", 5));
        logRes(res);
    }

    @Test
    public void mightContain1() {
        int containCount = 0;
        for (int i = PERSON_COUNT; i < PERSON_COUNT * 2; i++) {
            if (this.bloomFilter.mightContain(new Person(i + "", i))) {
                containCount++;
            }
        }

        logger.debug("containCount={},error ratio={}", containCount, containCount * 1.0 / PERSON_COUNT);
    }

    @Before
    public void init() {
        this.bloomFilter = BloomFilter.create(new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putString(from.getName(), Charsets.UTF_8);
            }
        }, PERSON_COUNT, 0.01);

        for (int i = 0; i < PERSON_COUNT; i++) {
            this.bloomFilter.put(new Person(i + "", i));
        }
    }
}

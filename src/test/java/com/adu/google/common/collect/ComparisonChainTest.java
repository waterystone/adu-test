package com.adu.google.common.collect;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author duyunjie
 * @date 2018/10/23 下午3:01
 */
public class ComparisonChainTest extends BaseTest {
    private List<Person> persons = Lists.newArrayList();

    @Test
    public void name() {
        Collections.sort(persons,
                ((o1, o2) -> ComparisonChain.start().compare(o1.getName().toLowerCase(), o2.getName().toLowerCase())
                        .compare(o1.getAge(), o2.getAge()).result()));

        print(persons);
    }

    @Before
    public void init() {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            String name = "" + random.nextInt(5);
            int age = random.nextInt(5);

            persons.add(new Person(name, age));
        }
    }
}

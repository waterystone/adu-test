package com.adu.jdk.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author duyunjie
 * @date 2019-06-17 17:28
 */
public class CollectorsTest extends BaseTest {
    private List<Person> personList = Arrays.asList(new Person("adu", 15), new Person("test", 20));

    @Test
    public void toMap() {
        Map<String, Person> res = personList.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        print(res);
    }
}

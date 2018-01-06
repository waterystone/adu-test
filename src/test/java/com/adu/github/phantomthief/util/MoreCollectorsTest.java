package com.adu.github.phantomthief.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.github.phantomthief.util.MoreCollectors;

/**
 *
 * @author duyunjie
 * @date 2017/12/18 下午5:31 
 */
public class MoreCollectorsTest extends BaseTest {

    private List<Integer> intList = Arrays.asList(1, 2, 3);
    private List<String> stringList = Arrays.asList("a", "b", "c");
    private List<Person> personList = Arrays.asList(new Person("adu", 15), new Person("test", 20));

    @Test
    public void toMap() {
        Map<String, Integer> res = personList.stream().collect(
                MoreCollectors.toMap(p -> p.getName(), p -> p.getAge(), LinkedHashMap::new));
        print(res);
    }
}

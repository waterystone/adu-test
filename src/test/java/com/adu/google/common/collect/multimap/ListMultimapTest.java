package com.adu.google.common.collect.multimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Ordering;

public class ListMultimapTest extends BaseTest {
    private ListMultimap<String, String> multimap;

    @Test
    public void orderTest() {
        ListMultimap<Integer, Integer> map = ArrayListMultimap.create();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1000; j++) {
                map.put(i, j);
            }
        }

        Ordering ordering = Ordering.natural();

        for (int i = 0; i < 10; i++) {
            List<Integer> list = map.get(i);
            boolean isOrder = ordering.isOrdered(list);
            if (!isOrder) {
                logger.warn("[WARN-order]i={},list={}", i, list);
            }
        }

        logger.info("end");
    }

    @Test
    public void test() {
        this.multimap.put("adu", null);
        boolean res = multimap.containsKey("adu");
        logger.info("res={}", res);
    }

    @Test
    public void size() {
        int res = multimap.size();
        logger.debug("res={}", res);
    }

    @Test
    public void asMap() {
        Map<String, Collection<String>> res = multimap.asMap();
        logger.debug("res={}", res);
    }

    @Test
    public void get() {
        List<String> res = multimap.get("b");
        print(res);
    }

    @Test
    public void remove() {
        boolean res = multimap.remove("b", "b2");
        logger.debug("res={}", res);
    }

    @Test
    public void removeAll() {
        List<String> res = multimap.removeAll("b");
        logger.debug("res={}", res);
    }

    @Test
    public void replaceValues() {
        List<String> res = multimap.replaceValues("b", Arrays.asList("b7", "b8"));
        logger.debug("res={}", res);
    }

    @Before
    public void init() {
        this.multimap = ArrayListMultimap.create();
        this.multimap.put("a", "a1");

        this.multimap.put("b", "b1");
        this.multimap.put("b", "b2");

        this.multimap.put("c", "c1");
        this.multimap.put("c", "c1");
        this.multimap.put("c", "c3");
    }

}

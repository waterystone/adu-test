package com.adu.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.math3.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class WeightRandomTest {
    List<Pair<String, Integer>> list;
    private WeightRandom<String, Integer> random;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void random() {
        Map<String, Integer> countMap = Maps.newHashMap();
        for (int i = 0; i < 100000000; i++) {
            String randomKey = random.random();
            countMap.put(randomKey, countMap.getOrDefault(randomKey, 0) + 1);
        }

        for (Pair<String, Integer> pair : list) {
            logger.debug("{}:{}", pair.getKey(), countMap.get(pair.getKey()));
        }
    }

    @Before
    public void init() {
        list = Lists.newArrayList();
        list.add(new Pair("A", 1));
        list.add(new Pair("B", 2));
        list.add(new Pair("C", 3));
        list.add(new Pair("D", 4));

        this.random = new WeightRandom(list);
    }

}

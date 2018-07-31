package com.adu.jdk.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Maps;

public class LinkedListTest extends BaseTest {

    @Test
    public void subList() {
        List<String> list = Arrays.asList("1", "2", "3");
        logRes(list.subList(3, 4));
    }

    @Test
    public void test() {
        List<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        logRes(list);
    }

    @Test
    public void test2() {
        Map<Integer, List<String>> listMultimap = Maps.newHashMap();

        List<String> list = new LinkedList<String>();
        for (int i = 1; i <= 9; i++) {
            list.add(String.valueOf(i));
            if (i % 3 == 0) {
                listMultimap.put(i, list);
                //list.clear();
            }
        }

        logRes(listMultimap);
    }

}

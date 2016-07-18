package com.adu.jdk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class ArrayListTest {
    private final Log logger = LogFactory.getLog(ArrayListTest.class);

    @Test
    public void subList() {
        List<String> list = Arrays.asList("1", "2", "3");
        logger.debug(list.subList(3, 4));
    }

    @Test
    public void forEach() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(e -> logger.debug(e));
    }

    @Test
    public void sort() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.sort((e1, e2) -> e1.compareTo(e2));
        logger.debug(list);
    }

}

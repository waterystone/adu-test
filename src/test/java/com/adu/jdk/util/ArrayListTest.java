package com.adu.jdk.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.adu.BaseTest;

public class ArrayListTest extends BaseTest {

    private List<BigDecimal> priceList = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"),
            new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12"));

    @Test
    public void subList() {
        List<String> list = Arrays.asList("1", "2", "3");
        print(list.subList(3, 4));
    }

    @Test
    public void forEach() {
        priceList.forEach(price -> logger.debug("{}", price));
    }

    @Test
    public void stream() {
        Stream<BigDecimal> res = priceList.stream();
        logRes(res);

    }

    @Test
    public void get() {
        List<Integer> list = new ArrayList<>();
        logRes(list.get(0));

    }

    @Test
    public void sort() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.sort((e1, e2) -> e1.compareTo(e2));
        print(list);
    }

    @Test
    public void sort2() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("def");
        list.add("bc");
        list.sort(Comparator.comparingInt(e -> e.length()));
        print(list);
    }

}

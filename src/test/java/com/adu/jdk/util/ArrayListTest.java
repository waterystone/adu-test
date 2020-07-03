package com.adu.jdk.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;

public class ArrayListTest extends BaseTest {

    private List<BigDecimal> priceList = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"),
            new BigDecimal("12"));

    @Test
    public void subList() {
        List<String> list = Arrays.asList("1", "2", "3");
        print(list.subList(3, 4));
    }

    @Test
    public void throwConcurrentModificationException() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        new Thread(() -> {
            for (Integer ele : list) {
                System.out.println(ele);
                Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            }
        }).start();

        new Thread(() -> {
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
            list.add(4);
        }).start();

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.MINUTES);
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
    public void remove() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }

        logger.info("op=end_remove,list={}", list);
    }

    @Test
    public void remove2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer ele = iterator.next();
            if (ele == 2) {
                iterator.remove();
            }
        }

        logger.info("op=end_remove,list={}", list);
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

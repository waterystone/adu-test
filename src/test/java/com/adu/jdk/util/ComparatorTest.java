package com.adu.jdk.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

public class ComparatorTest extends BaseTest {

    Comparator<String> comparator = (String s1, String s2) -> s1.compareTo(s2);
    List<String> list = Arrays.asList("a", "c", "b");

    @Test
    public void sort() {
        list.sort(comparator);
        print(list);
    }
}

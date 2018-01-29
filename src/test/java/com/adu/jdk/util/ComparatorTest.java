package com.adu.jdk.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

public class ComparatorTest extends BaseTest {

    Comparator<String> comparator = (String s1, String s2) -> s1.compareTo(s2);
    List<String> list = Arrays.asList("ab", "c", "def");

    @Test
    public void sort() {
        list.sort(comparator);
        print(list);
    }

    @Test
    public void comparingInt() {
        list.sort(Comparator.comparingInt(e -> e.length()));
        print(list);
    }
}

package com.adu.jdk.util;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/6/27 15:03
 */
public class LinkedHashSetTest extends BaseTest {
    private HashSet<String> set;

    @Test
    public void print() {
        print(set);
    }

    @Before
    public void init() {
        this.set = new LinkedHashSet();
        this.set.add("a");
        this.set.add("b");
        this.set.add("c");
        this.set.add("b");
    }
}

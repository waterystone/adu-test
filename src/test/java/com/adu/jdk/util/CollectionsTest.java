package com.adu.jdk.util;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Lists;

/**
 * @author yunjie.du
 * @date 2017/3/10 11:21
 */
public class CollectionsTest extends BaseTest {

    @Test
    public void sort() {
        List<Integer> list = Lists.newArrayList(1);
        Collections.sort(list);
        print(list);
    }

    @Test
    public void fill() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Collections.fill(list, -1);
        print(list);
    }
}

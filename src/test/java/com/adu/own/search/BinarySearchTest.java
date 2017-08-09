package com.adu.own.search;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/8/9 17:27
 */
public class BinarySearchTest extends BaseTest {
    @Test
    public void search() {
        Integer[] array = { 1, 2, 3 };
        int res = BinarySearch.search(array, 2);
        logRes(res);
    }

    @Test
    public void searchMaxLessEqualsThan() {
        Integer[] array = { 1, 2, 3 };
        int res = BinarySearch.searchMaxLessThanOrEquals(array, 10);
        logRes(res);
    }
}

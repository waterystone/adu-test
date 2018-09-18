package com.adu.hutool.bloomfilter;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import com.adu.BaseTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午5:41
 */
public class BitMapBloomFilterTest extends BaseTest {
    public static final int COUNT = 100;
    private BitMapBloomFilter bitMapBloomFilter = new BitMapBloomFilter(COUNT);

    @Test
    public void contains() {
        boolean res = bitMapBloomFilter.contains("10");
        logRes(res);
    }

    @Before
    public void init() {
        for (int i = 0; i < COUNT; i++) {
            bitMapBloomFilter.add("" + i);
        }
    }
}

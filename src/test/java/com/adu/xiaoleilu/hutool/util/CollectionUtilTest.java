package com.adu.xiaoleilu.hutool.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.CollectionUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午10:38
 */
public class CollectionUtilTest extends BaseTest {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    public void split() {
        List<List<Integer>> res = CollectionUtil.split(list, 1);
        print(res);
    }
}

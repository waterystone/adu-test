package com.adu.hutool.core.math;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;

import cn.hutool.core.math.MathUtil;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:59
 */
public class MathUtilTest extends BaseTest {
    String[] array = new String[] { "a", "b", "c" };

    @Test
    public void arrangementSelect() {
        List<String[]> res = MathUtil.arrangementSelect(array);
        print(res);
    }
}

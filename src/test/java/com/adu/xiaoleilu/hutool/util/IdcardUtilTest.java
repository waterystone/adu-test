package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.IdcardUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午10:58
 */
public class IdcardUtilTest extends BaseTest {
    @Test
    public void isValidCard() {
        boolean res = IdcardUtil.isValidCard("411303198105215511");
        logRes(res);
    }
}

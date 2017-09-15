package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.CharsetUtil;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午6:03
 */
public class CharsetUtilTest extends BaseTest {
    @Test
    public void convert() {
        String res = CharsetUtil.convert("adu", CharsetUtil.CHARSET_UTF_8, CharsetUtil.CHARSET_GBK);
        logRes(res);
    }
}

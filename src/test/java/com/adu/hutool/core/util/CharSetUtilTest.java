package com.adu.hutool.core.util;

import cn.hutool.core.util.CharsetUtil;
import com.adu.BaseTest;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:07
 */
public class CharSetUtilTest extends BaseTest {
    @Test
    public void systemCharset() {
        Charset res = CharsetUtil.systemCharset();
        logRes(res);
    }
}

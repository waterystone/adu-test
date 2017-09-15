package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.EscapeUtil;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午6:17
 */
public class EscapeUtilTest extends BaseTest {
    @Test
    public void escape() {
        String res = EscapeUtil.escape("http://www.baidu.com");
        logRes(res);
    }

    @Test
    public void unescape() {
        String res = EscapeUtil.unescape("http%3a%2f%2fwww%2ebaidu%2ecom");
        logRes(res);
    }
}

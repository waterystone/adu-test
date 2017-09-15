package com.adu.xiaoleilu.hutool.http;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.http.HttpUtil;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/15 下午2:53
 */
public class HttpUtilTest extends BaseTest {
    @Test
    public void get() {
        String res = HttpUtil.get("http://www.baidu.com");
        logRes(res);
    }
}

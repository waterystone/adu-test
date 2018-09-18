package com.adu.hutool.http;

import cn.hutool.http.HttpUtil;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:28
 */
public class HttpUtilTest extends BaseTest {
    @Test
    public void get() {
        String res = HttpUtil.get("http://gc.ditu.aliyun.com/regeocoding?type=010&l=39.908722,116.397499");
        logRes(res);
    }
}

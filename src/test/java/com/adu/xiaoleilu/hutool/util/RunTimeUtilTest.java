package com.adu.xiaoleilu.hutool.util;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.util.RuntimeUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 上午11:47
 */
public class RunTimeUtilTest extends BaseTest {
    @Test
    public void exec() {
        List<String> res = RuntimeUtil.exec("ls");
        print(res);
    }
}

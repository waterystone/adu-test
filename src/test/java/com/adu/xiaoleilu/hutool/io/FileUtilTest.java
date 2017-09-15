package com.adu.xiaoleilu.hutool.io;

import java.util.List;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.io.FileUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 下午2:55
 */
public class FileUtilTest extends BaseTest {
    @Test
    public void readUtf8Lines() {
        List<String> res = FileUtil.readUtf8Lines(this.getClass().getClassLoader().getResource("ids.txt"));
        logRes(res);

    }
}

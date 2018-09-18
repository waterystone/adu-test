package com.adu.hutool.core.file;

import org.junit.Test;

import com.adu.BaseTest;

import cn.hutool.core.io.FileUtil;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:49
 */
public class FileUtilTest extends BaseTest {
    @Test
    public void readString() {
        String res = FileUtil.readString(FileUtilTest.class.getClassLoader().getResource("a.txt"), "UTF-8");
        logRes(res);
    }
}

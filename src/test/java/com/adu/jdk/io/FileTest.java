package com.adu.jdk.io;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/4/7 11:44
 */
public class FileTest extends BaseTest {
    private File file;

    @Test
    public void lastModified() {
        long res = file.lastModified();
        logRes(res);
    }

    @Before
    public void init() {
        file = new File("D:/test/IMG_3018.JPG");
    }
}

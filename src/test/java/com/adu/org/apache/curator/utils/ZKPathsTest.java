package com.adu.org.apache.curator.utils;

import org.apache.curator.utils.ZKPaths;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/3/30 11:39
 */
public class ZKPathsTest extends BaseTest {
    @Test
    public void getPathAndNode() {
        ZKPaths.PathAndNode res = ZKPaths.getPathAndNode("/a/b");
        logRes(res);
    }
}

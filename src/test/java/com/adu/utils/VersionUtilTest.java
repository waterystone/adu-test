package com.adu.utils;

import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2019-08-20 17:51
 */
public class VersionUtilTest extends BaseTest {
    @Test
    public void compareVersion() {
        int res = VersionUtil.compareVersion("guava-12.3.5-SN.jar", "guava-27.0.1.jar");
        logRes(res);
    }

    @Test
    public void extractVersion() {
        String fullJarName = "guava-23.1.jar";
        String res = VersionUtil.extractVersion(fullJarName);
        logRes(res);
    }
}

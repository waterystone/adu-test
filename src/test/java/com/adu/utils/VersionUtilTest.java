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
        int res = VersionUtil.compareVersion("guava-23.0.jar", "guava-27.0.1-jre.jar");
        logRes(res);
    }

    @Test
    public void extractVersion() {
        String fullJarName = "guava-27.0.1-jre.jar";
        String res = VersionUtil.extractVersion(fullJarName);
        logRes(res);
    }
}

package com.adu.spatial4j.core.io;

import org.junit.Test;

import com.adu.BaseTest;
import com.spatial4j.core.io.GeohashUtils;

/**
 * @author yunjie.du
 * @date 2017/9/8 上午11:27
 */
public class GeohashUtilsTest extends BaseTest {
    @Test
    public void encodeLatLon() {
        String res = GeohashUtils.encodeLatLon(39.983733, 116.312528, 5);
        logRes(res);
    }
}

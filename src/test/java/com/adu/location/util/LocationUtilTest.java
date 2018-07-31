package com.adu.location.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.location.model.LocateInfo;

/**
 * @author duyunjie
 * @date 2018/7/31 上午11:52
 */
public class LocationUtilTest extends BaseTest {
    @Test
    public void wgs84ToGcj02() {
        LocateInfo res = LocationUtil.wgs84ToGcj02(33.6349296087, 85.8668771250);
        logRes(res);
    }

    @Test
    public void gcj02ToWgs84() {
        LocateInfo res = LocationUtil.gcj02ToWgs84(33.6329157387,85.8691406250);
        logRes(res);
    }
}

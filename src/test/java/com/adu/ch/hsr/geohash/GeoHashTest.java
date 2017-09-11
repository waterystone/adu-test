package com.adu.ch.hsr.geohash;

import org.junit.Test;

import com.adu.BaseTest;

import ch.hsr.geohash.GeoHash;

/**
 * @author yunjie.du
 * @date 2017/9/8 上午11:34
 */
public class GeoHashTest extends BaseTest {
    private double lat = 39.983733, lon = 116.312528;
    GeoHash geo = GeoHash.withCharacterPrecision(lat, lon, 8);

    @Test
    public void withCharacterPrecision() {
        GeoHash res = GeoHash.withCharacterPrecision(lat, lon, 8);
        logRes(res);
    }

    @Test
    public void geoHashStringWithCharacterPrecision() {
        for (int number = 1; number <= 12; number++) {
            String res = GeoHash.geoHashStringWithCharacterPrecision(lat, lon, number);
            logRes(res);
        }
    }

    @Test
    public void getAdjacent() {
        GeoHash[] res = geo.getAdjacent();
        print(res);
    }
}

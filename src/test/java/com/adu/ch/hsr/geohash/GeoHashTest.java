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


    /**
     *
     geohash length	lat bits	lng bits	lat error	lng error	km error
     1	2	3	±23	±23	±2500
     2	5	5	 ±2.8	 ±5.6	 ±630
     3	7	8	 ±0.70	 ±0.70	  ±78
     4	10	10	 ±0.087	 ±0.18	  ±20
     5	12	13	 ±0.022	 ±0.022	   ±2.4
     6	15	15	 ±0.0027	 ±0.0055	   ±0.61
     7	17	18	 ±0.00068	 ±0.00068	   ±0.076
     8	20	20	 ±0.000085	 ±0.00017	   ±0.019

     *
     */
    /**
     * 计算指定区域内GeoHash的个数
     */
    @Test
    public void computeCount() {
        double south = 4, north = 54, west = 73, east = 135;
        int count = 0, row = 1;
        GeoHash geo = GeoHash.withCharacterPrecision(west, north, 5);
        while (geo.getBoundingBox().getMinLat() > south) {
            GeoHash next = geo;
            int rowCount = 0;
            while (next.getBoundingBox().getMaxLon() < east) {
                rowCount++;
                next = next.getEasternNeighbour();
            }
            logger.info("[{}]{}", row++, rowCount);

            count += rowCount;
            geo = geo.getSouthernNeighbour();
        }

        logger.info("count={}", count);
    }
}

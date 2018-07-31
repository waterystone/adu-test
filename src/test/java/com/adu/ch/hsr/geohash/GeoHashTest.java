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

    @Test
    public void latitudeRange() {
        GeoHash geo = GeoHash.withCharacterPrecision(39.908722, 116.397499, 6);
        for (int i = 1; i < 10; i++) {
            logger.info("[{}],{}-{},{}", i, geo.getBoundingBox().getMinLat(), geo.getBoundingBox().getMaxLat(),
                    geo.getBoundingBox().getCenterPoint());

            geo = geo.getNorthernNeighbour();
        }
    }

    @Test
    public void longitudeRange() {
        GeoHash geo = GeoHash.withCharacterPrecision(39.908722, 116.397499, 6);
        for (int i = 1; i < 10; i++) {
            logger.info("[{}]{}-{},{}", i, geo.getBoundingBox().getMinLon(), geo.getBoundingBox().getMaxLon(),
                    geo.getBoundingBox().getCenterPoint());

            geo = geo.getEasternNeighbour();
        }
    }

    /**
     * 计算指定区域内GeoHash的个数
     */
    @Test
    public void computeCount() {
        double south = 4, north = 54, west = 73, east = 135;
        int count = 0, row = 1;
        GeoHash geo = GeoHash.withCharacterPrecision(north, west, 6);
        while (geo.getBoundingBox().getMinLat() > south) {
            GeoHash next = geo;
            int rowCount = 0;
            while (next.getBoundingBox().getMaxLon() < east) {
                rowCount++;
                next = next.getEasternNeighbour();
            }

            row++;
            if (row % 100 == 0) {
                logger.info("[{}]{}", row, rowCount);
            }

            count += rowCount;
            geo = geo.getSouthernNeighbour();
        }

        logger.info("row={},count={}", row, count);
    }
}

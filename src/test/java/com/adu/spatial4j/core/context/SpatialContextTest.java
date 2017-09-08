package com.adu.spatial4j.core.context;

import org.junit.Test;

import com.adu.BaseTest;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.shape.Rectangle;

/**
 * @author yunjie.du
 * @date 2017/9/8 上午11:01
 */
public class SpatialContextTest extends BaseTest {
    private SpatialContext geo = SpatialContext.GEO;

    @Test
    public void calcDistance() {
        double res = geo.calcDistance(geo.makePoint(0, 0), geo.makePoint(1, 1));
        logRes(res);
    }

    /**
     * 计算以(lon,lat)为圆心，以radius为半径的圆的外切正方形
     */
    @Test
    public void calcBoxByDistFromPt() {
        // 圆心经纬度
        double lon = 116.312528, lat = 39.983733;
        // 半径：千米
        int radius = 1;

        Rectangle res = geo.getDistCalc().calcBoxByDistFromPt(geo.makePoint(lon, lat), radius * DistanceUtils.KM_TO_DEG,
                geo, null);
        logRes(res);
    }
}

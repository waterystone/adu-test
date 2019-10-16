package com.adu.utils;

import com.adu.BaseTest;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author duyunjie
 * @date 2019-10-16 14:54
 */
public class FlickrUtilTest extends BaseTest {
    @Test
    public void search() {
        Map<String, String> params = Maps.newHashMap();
        params.put("bbox", "116.0699,39.7383,116.6322,40.1159");
        params.put("geo_context", "2");

        String res = FlickrUtil.searchPhotos(params, 1);
        logRes(res);
    }

    @Test
    public void getPhotoInfo() {
        long photoId = 48097882431L;

        String res = FlickrUtil.getPhotoInfo(photoId);
        logRes(res);
    }

    @Test
    public void searchPhotoInfos() throws Exception {
        Map<String, String> params = Maps.newHashMap();
        params.put("bbox", "116.0699,39.7383,116.6322,40.1159");
        params.put("geo_context", "2");

        String res = FlickrUtil.searchPhotoInfos(params);
        Files.write(Paths.get("photo_info.txt"), res.getBytes("UTF-8"));
        logRes(res);
    }


}

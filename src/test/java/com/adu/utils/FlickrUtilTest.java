package com.adu.utils;

import com.adu.BaseTest;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
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
        params.put("bbox", "116.06,39.80,116.65,40.16");//经纬度范围
        params.put("geo_context", "2");//outdoor
        params.put("content_type", "1");//拍摄的照片

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
        params.put("bbox", "116.06,39.80,116.65,40.16");
        params.put("geo_context", "2");
        params.put("content_type", "1");
        params.put("per_page", "100");

        int startPage = 2581;
        while (true) {
            int endPage = startPage + 10;
            String res = FlickrUtil.searchPhotoInfos(params, startPage, endPage);
            if (StringUtils.isEmpty(res)) {
                logger.info("[empty_searchPhotoInfos]startPage={}", startPage);
                continue;
            }

            String fileName = String.format("D:\\data\\flickr\\%04d.txt", startPage);
            Files.write(Paths.get(fileName), res.getBytes("UTF-8"));
            logger.info("[success_write_file]startPage={}", startPage);

            startPage = endPage;
            if (startPage > 2950) {
                break;
            }
        }
        //logRes(res);
    }


}

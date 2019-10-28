package com.adu.utils;

import com.adu.BaseTest;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        params.put("per_page", "100");

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
        HttpClientUtil.init(20, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        SearchPhotoInfoTask searchPhotoInfoTask1 = new SearchPhotoInfoTask(LocalDate.parse("2012-01-01"), LocalDate.parse("2013-12-31"));
        SearchPhotoInfoTask searchPhotoInfoTask2 = new SearchPhotoInfoTask(LocalDate.parse("2014-01-01"), LocalDate.parse("2015-12-31"));
        SearchPhotoInfoTask searchPhotoInfoTask3 = new SearchPhotoInfoTask(LocalDate.parse("2016-01-01"), LocalDate.parse("2017-12-31"));
        SearchPhotoInfoTask searchPhotoInfoTask4 = new SearchPhotoInfoTask(LocalDate.parse("2018-01-01"), LocalDate.parse("2019-10-31"));

        executorService.submit(searchPhotoInfoTask1);
        executorService.submit(searchPhotoInfoTask2);
        executorService.submit(searchPhotoInfoTask3);
        executorService.submit(searchPhotoInfoTask4);

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.DAYS);
    }

    class SearchPhotoInfoTask implements Runnable {
        private LocalDate minDate;
        private LocalDate maxDate;

        public SearchPhotoInfoTask(LocalDate minDate, LocalDate maxDate) {
            this.minDate = minDate;
            this.maxDate = maxDate;
        }

        @Override
        public void run() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Thread.currentThread().setName(String.format("search-%s", formatter.format(minDate)));
            LocalDate startDate = minDate;

            Map<String, String> params = Maps.newHashMap();
            params.put("bbox", "116.06,39.80,116.65,40.16");
            params.put("geo_context", "2");
            params.put("content_type", "1");
            params.put("per_page", "200");

            while (true) {
                try {
                    LocalDate endDate = startDate.plusMonths(1);
                    params.put("min_taken_date", formatter.format(startDate));
                    params.put("max_taken_date", formatter.format(endDate));
                    String res = FlickrUtil.searchPhotoInfos(params, 1, 30);
                    if (StringUtils.isEmpty(res)) {
                        logger.info("[empty_searchPhotoInfos]startDate={},endDate={}", startDate, endDate);
                        continue;
                    }

                    String fileName = String.format("D:\\data\\flickr\\%s.txt", formatter.format(startDate));
                    //String fileName = String.format("/Users/yunjie.du/data/flickr/2/data/%s.txt", formatter.format(startDate));
                    Files.write(Paths.get(fileName), res.getBytes("UTF-8"));
                    logger.info("[success_write_file]startDate={}", startDate);

                    startDate = endDate;
                    if (startDate.isAfter(maxDate)) {
                        break;
                    }
                } catch (IOException e) {
                    logger.error("[ERROR_run]startDate={},endDate={}", startDate, e);
                }
            }
        }
    }


}

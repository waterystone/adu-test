package com.adu.utils;

import com.adu.model.HttpOptions;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Flickr的API工具。参考：https://www.flickr.com/services/api/。
 *
 * @author duyunjie
 * @date 2019-10-16 14:46
 */
public class FlickrUtil {
    private static final HttpOptions httpOptions = new HttpOptions().setRetryCount(3);
    private static final String URL = "https://www.flickr.com/services/rest";
    private static final Logger logger = LoggerFactory.getLogger(FlickrUtil.class);

    /**
     * 搜索。参考：https://www.flickr.com/services/api/flickr.photos.search.html
     *
     * @param params
     * @param page
     * @return json格式，null表示出现错误。
     */
    public static String searchPhotos(Map<String, String> params, int page) {
        addCommonParams(params);
        params.put("method", "flickr.photos.search");
        params.put("page", String.valueOf(page));

        String res = null;
        try {
            //TODO
            //res = HttpClientUtil.httpGet("https://api.flickr.com/services/rest", params, httpOptions);
            res = mockSearchResult();
            res = deleteInvalidChars(res);
        } catch (Exception e) {
            logger.error("[ERROR_search]params={},page={}", params, page, e);
        }

        return res;
    }

    /**
     * 获取照片的信息。参考：https://www.flickr.com/services/api/flickr.photos.getInfo.html
     *
     * @param photoId
     * @return
     */
    public static String getPhotoInfo(long photoId) {
        Map<String, String> params = Maps.newHashMap();
        addCommonParams(params);
        params.put("method", "flickr.photos.getInfo");
        params.put("photo_id", String.valueOf(photoId));

        String res = null;
        try {
            //TODO
            //res = HttpClientUtil.httpGet("https://api.flickr.com/services/rest", params, httpOptions);
            res = mockPhotoInfoResult();
            res = deleteInvalidChars(res);
        } catch (Exception e) {
            logger.error("[ERROR_getPhotoInfo]photoId={}", photoId, e);
        }

        return res;
    }

    private static final Joiner COLUMN_JOINER = Joiner.on("&&").useForNull("null");
    private static String HEADER = COLUMN_JOINER.join(Lists.newArrayList("id", "title", "taken_date", "tags", "longitude", "latitude", "accuracy", "country", "county", "region", "locality", "url"));

    /**
     * 搜索并获取照片的详细信息，可用于表格转换。
     *
     * @param params
     * @return 每个照片信息一行，列之间用"&&"分隔（带表头）。
     */
    public static String searchPhotoInfos(Map<String, String> params) {
        StringBuilder builder = new StringBuilder(HEADER + "\n");
        int page = 1;
        while (true) {//分页搜索
            //1.搜索
            String searchPhotos = searchPhotos(params, page);
            if (Objects.nonNull(searchPhotos)) {
                JSONObject searchPhotosJsonObject = JSON.parseObject(searchPhotos);
                if (Objects.equals(searchPhotosJsonObject.getString("stat"), "ok")) { //判断结果stat是否ok
                    JSONObject photosJsonObject = searchPhotosJsonObject.getJSONObject("photos");
                    int totalPage = photosJsonObject.getIntValue("pages");

                    JSONArray photoJsonArray = photosJsonObject.getJSONArray("photo");
                    //2.处理该页内的照片
                    for (int i = 0; i < photoJsonArray.size(); i++) {
                        JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);
                        long photoId = photoJsonObject.getLong("id"); //拿到photoId

                        //3.获取详细的照片信息
                        String photoInfo = getPhotoInfo(photoId);

                        //4.转换成以"&&"分隔的各列信息
                        String parsedPhotoInfo = parsePhotoInfo(photoId, photoInfo);

                        //5.加入结果
                        if (Objects.nonNull(parsedPhotoInfo)) {
                            builder.append(parsedPhotoInfo + "\n");
                        }
                    }

                    logger.info("[end_searchPhotoInfos_page]page={},size={},totalPage={}", page, photoJsonArray.size(), totalPage);
                    if (page == totalPage) {
                        break;
                    }
                    page++;
                } else {
                    logger.error("[ERROR_searchPhotosStat]parmas={},page={},searchPhotos={}", page, page, searchPhotos);
                }
            }
        }

        return builder.toString();
    }


    private static final Joiner COMMA_JOINER = Joiner.on(",").useForNull("null");

    /**
     * 将单个照片的详细json信息转换成以"&&"分隔的各列信息。
     *
     * @param photoId
     * @param photoInfo json格式。
     * @return
     */
    private static String parsePhotoInfo(long photoId, String photoInfo) {
        if (Objects.isNull(photoInfo)) {
            return null;
        }

        JSONObject photoInfoJsonObject = JSON.parseObject(photoInfo);
        if (!Objects.equals(photoInfoJsonObject.getString("stat"), "ok")) {
            logger.error("[ERROR_photoInfoStat]photoId={},photoInfo={}", photoId, photoInfo);
            return null;
        }

        try {
            JSONObject photoJsonObject = photoInfoJsonObject.getJSONObject("photo");
            String title = photoJsonObject.getJSONObject("title").getString("_content");
            String takenDate = photoJsonObject.getJSONObject("dates").getString("taken");

            List<String> tagList = Lists.newArrayList();
            JSONArray tagJsonArray = photoJsonObject.getJSONObject("tags").getJSONArray("tag");
            for (int i = 0; i < tagJsonArray.size(); i++) {
                JSONObject tagJsonObject = tagJsonArray.getJSONObject(i);
                tagList.add(tagJsonObject.getString("_content"));
            }
            String tags = COMMA_JOINER.join(tagList);

            String longitude = null;
            String latitude = null;
            String accuracy = null;
            String country = null;
            String county = null;
            String region = null;
            String locality = null;
            JSONObject locationJsonObject = photoJsonObject.getJSONObject("location");
            if (Objects.nonNull(locationJsonObject)) {
                longitude = locationJsonObject.getString("longitude");
                latitude = locationJsonObject.getString("latitude");
                accuracy = locationJsonObject.getString("accuracy");
                country = locationJsonObject.getJSONObject("country").getString("_content");
                county = locationJsonObject.getJSONObject("county").getString("_content");
                region = locationJsonObject.getJSONObject("region").getString("_content");
                locality = locationJsonObject.getJSONObject("locality").getString("_content");
            }

            String url = photoJsonObject.getJSONObject("urls").getJSONArray("url").getJSONObject(0).getString("_content");

            List<String> columnValues = Lists.newArrayList(String.valueOf(photoId), title, takenDate, tags, longitude, latitude, accuracy, country, county, region, locality, url);
            return COLUMN_JOINER.join(columnValues);
        } catch (Exception e) {
            logger.error("[ERROR_parsePhotoInfo]photoId={},photoInfo={}", photoId, photoInfo, e);
        }

        return null;
    }


    private static String deleteInvalidChars(String json) {
        if (Objects.isNull(json)) {
            return null;
        }

        if (json.startsWith("jsonFlickrApi")) {
            return json.substring(14, json.length() - 1);
        }

        return json;
    }


    private static void addCommonParams(Map<String, String> params) {
        params.put("api_key", "38b5b6afbb6a7f604cc6487ff07aec70");
        params.put("format", "json");
    }

    private static String mockSearchResult() {
        String res = "jsonFlickrApi({\"photos\":{\"page\":1,\"pages\":3,\"perpage\":3,\"total\":\"293195\",\"photo\":[{\"id\":\"48906988047\",\"owner\":\"162735697@N08\",\"secret\":\"d198778086\",\"server\":\"65535\",\"farm\":66,\"title\":\"Beijing\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"48906258558\",\"owner\":\"162735697@N08\",\"secret\":\"e38bb4aca1\",\"server\":\"65535\",\"farm\":66,\"title\":\"Beijing\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},{\"id\":\"48906784736\",\"owner\":\"162735697@N08\",\"secret\":\"de340d8bfb\",\"server\":\"65535\",\"farm\":66,\"title\":\"Beijing\",\"ispublic\":1,\"isfriend\":0,\"isfamily\":0}]},\"stat\":\"ok\"})";
        return res;
    }

    private static String mockPhotoInfoResult() {
        String res = "jsonFlickrApi({\"photo\":{\"id\":\"48097882431\",\"secret\":\"a8d28769d6\",\"server\":\"65535\",\"farm\":66,\"dateuploaded\":\"1561040182\",\"isfavorite\":0,\"license\":\"0\",\"safety_level\":\"0\",\"rotation\":0,\"originalsecret\":\"c43f91cdb6\",\"originalformat\":\"jpg\",\"owner\":{\"nsid\":\"24862621@N04\",\"username\":\"kerstdejong\",\"realname\":\"Kerst de Jong\",\"location\":\"NY State, USA\",\"iconserver\":\"7172\",\"iconfarm\":8,\"path_alias\":null},\"title\":{\"_content\":\"Beijing\"},\"description\":{\"_content\":\"\"},\"visibility\":{\"ispublic\":1,\"isfriend\":0,\"isfamily\":0},\"dates\":{\"posted\":\"1561040182\",\"taken\":\"2019-06-15 20:04:17\",\"takengranularity\":\"0\",\"takenunknown\":\"0\",\"lastupdate\":\"1563516450\"},\"views\":\"52\",\"editability\":{\"cancomment\":0,\"canaddmeta\":0},\"publiceditability\":{\"cancomment\":1,\"canaddmeta\":0},\"usage\":{\"candownload\":1,\"canblog\":0,\"canprint\":0,\"canshare\":1},\"comments\":{\"_content\":\"0\"},\"notes\":{\"note\":[]},\"people\":{\"haspeople\":0},\"tags\":{\"tag\":[{\"id\":\"24830482-48097882431-49\",\"author\":\"24862621@N04\",\"authorname\":\"kerstdejong\",\"raw\":\"China\",\"_content\":\"china\",\"machine_tag\":0},{\"id\":\"24830482-48097882431-13184\",\"author\":\"24862621@N04\",\"authorname\":\"kerstdejong\",\"raw\":\"Xi'an\",\"_content\":\"xian\",\"machine_tag\":0},{\"id\":\"24830482-48097882431-7300\",\"author\":\"24862621@N04\",\"authorname\":\"kerstdejong\",\"raw\":\"Beijing\",\"_content\":\"beijing\",\"machine_tag\":0}]},\"location\":{\"latitude\":\"39.949691\",\"longitude\":\"116.409858\",\"accuracy\":\"16\",\"context\":\"0\",\"locality\":{\"_content\":\"Dongcheng District\"},\"county\":{\"_content\":\"Beijing\"},\"region\":{\"_content\":\"Beijing\"},\"country\":{\"_content\":\"China\"},\"neighbourhood\":{\"_content\":\"\"}},\"geoperms\":{\"ispublic\":1,\"iscontact\":0,\"isfriend\":0,\"isfamily\":0},\"urls\":{\"url\":[{\"type\":\"photopage\",\"_content\":\"https:\\/\\/www.flickr.com\\/photos\\/24862621@N04\\/48097882431\\/\"}]},\"media\":\"photo\"},\"stat\":\"ok\"})";
        return res;
    }
}

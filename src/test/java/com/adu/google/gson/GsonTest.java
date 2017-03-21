package com.adu.google.gson;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.internal.LinkedTreeMap;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * @author yunjie.du
 * @date 2017/3/21 15:37
 */
public class GsonTest extends BaseTest {
    private Gson gson;

    @Test
    public void test() {
        JSONObject object = new JSONObject();
        for (int i = 0; i < 100; i++) {
            object.put(i + "", i);
        }

        JSONObject childObject = new JSONObject();
        for (int i = 0; i < 100; i++) {
            childObject.put(i + "", i);
        }
        object.put("childObject", childObject);
        String json = object.toJSONString();

        Map res = gson.fromJson(json, LinkedTreeMap.class);
        logger.info("res={}", res);
    }

    @Before
    public void init() {
        this.gson = new Gson();
    }
}

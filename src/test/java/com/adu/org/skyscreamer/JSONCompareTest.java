package com.adu.org.skyscreamer;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/3/1 18:11
 */
public class JSONCompareTest extends BaseTest {
    private String expected, actual;

    @Test
    public void compareJSON() throws JSONException {
        JSONCompareResult res = JSONCompare.compareJSON(expected, actual, JSONCompareMode.STRICT);
        logRes(res);
    }

    @Before
    public void init() {
        expected = "{\"a\":1,\"b\": [{\"a\":1,\"b\":2}]}";
        actual = "{\"a\":2,\"b\": [{\"a\":1,\"b\":3}],\"d\":3}";
    }
}

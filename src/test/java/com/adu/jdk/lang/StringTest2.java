package com.adu.jdk.lang;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.collect.Maps;

/**
 * @author duyunjie
 * @date 2020-08-31 19:06
 */
public class StringTest2 extends BaseTest {
    private Map<String, Object> map = Maps.newHashMap();

    private <T> T get(String key) {
        return (T) map.get(key);
    }

    @Test
    public void valueOf() {
        Object o = get("1");
        String res = String.valueOf(get("1"));
        logRes(res);

    }

    @Before
    public void init() {
        map.put("1", 1);
    }
}

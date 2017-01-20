package com.adu.org.apache.commons.collections4;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections4.MapUtils;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;

/**
 * @author yunjie.du
 * @date 2017/1/18 16:09
 */
public class MapUtilsTest extends BaseTest {
    private Map<String, Object> map;

    @Test
    public void getIntValue() {
        int res = MapUtils.getIntValue(map, "a", -1);
        logger.debug("res={}", res);
    }

    @Test
    public void isEmpty() {
        boolean res = MapUtils.isEmpty(map);
        logger.debug("res={}", res);
    }

    @Before
    public void init() {
        map = new <String, Object> HashedMap();
        map.put("a", 1);
        map.put("person", new Person("adu", 27));
    }
}

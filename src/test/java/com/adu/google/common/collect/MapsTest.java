package com.adu.google.common.collect;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class MapsTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void newHashMap() {
        Map<String, String> res = Maps.newHashMap();
        res.put("a", "1");
        res.put("b", "2");
        res.put("c", "3");
        logger.debug(res);
    }

    @Test
    public void newConcurrentMap() {
        Map<String, String> res = Maps.newConcurrentMap();
        res.put("a", "1");
        res.put("b", "2");
        res.put("c", "3");
        logger.debug(res);
    }

}

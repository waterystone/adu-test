package com.adu.google.common.collect;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.collect.Maps;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class SetsTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void newHashSet() {
        Set<String> res = Sets.newHashSet();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug(res);
    }

    @Test
    public void newConcurrentHashSet() {
        Set<String> res = Sets.newConcurrentHashSet();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug(res);
    }

}

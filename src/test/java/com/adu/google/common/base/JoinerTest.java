package com.adu.google.common.base;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

public class JoinerTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void join() {
        List<String> list = Arrays.asList("a", "b", "c");
        String res = Joiner.on(",").join(list);
        logger.debug(res);
    }

    @Test
    public void withKeyValueSeparator() {
        Map<String, Integer> parameters = Maps.newTreeMap();
        parameters.put("ad", 1);
        parameters.put("aa", 4);
        parameters.put("ac", 2);
        parameters.put("ab", 3);
        String res = Joiner.on("&").withKeyValueSeparator("=").join(parameters);
        logger.debug(res);
    }
}

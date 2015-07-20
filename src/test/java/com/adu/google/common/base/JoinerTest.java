package com.adu.google.common.base;

import com.adu.lang.StringBufferTest;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        Map<String, Integer> parameters = Maps.newHashMap();
        parameters.put("a", 1);
        parameters.put("b", 2);
        parameters.put("c", 3);
        String res = Joiner.on("&").withKeyValueSeparator("=").join(parameters);
        logger.debug(res);
    }
}

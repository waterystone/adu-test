package com.adu.google.common.base;

import com.google.common.base.Joiner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JoinerTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void join() {
        List<String> list = Arrays.asList("a", "b", "c");
        String res = Joiner.on(",").join(list);
        logger.debug(res);
    }
}

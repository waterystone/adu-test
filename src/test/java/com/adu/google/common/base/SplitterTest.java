package com.adu.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yunjie.du on 2015/7/8.
 */
public class SplitterTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void splitToList() {
        String str = "a,b,c";
        List<String> res = Splitter.on(",").splitToList(str);
        logger.debug(res);
    }
}

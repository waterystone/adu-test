package com.adu.google.common.collect;

import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.List;

/**
 * Created by yunjie.du on 2015/7/9.
 */
public class ListsTest {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void newArrayList() {
        List<String> res = Lists.newArrayList("a", "b", "c");
        logger.debug(res);
    }

    @Test
    public void newLinkedList() {
        List<String> res = Lists.newLinkedList();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug(res);
    }

    @Test
    public void newCopyOnWriteArrayList() {
        List<String> res = Lists.newCopyOnWriteArrayList();
        res.add("a");
        res.add("b");
        res.add("c");
        logger.debug(res);
    }
}

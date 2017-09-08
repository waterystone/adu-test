package com.adu;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.utils.StringUtil;

/**
 * @author yunjie.du
 * @date 2016/10/19 18:33
 */
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void print(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.debug("[{}]{}", ++i, iterator.next());
        }
    }

    protected <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            logger.debug("[{}]{}", i + 1, arr[i]);
        }
    }

    protected void print(Map<?, ?> map) {
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            logger.debug("[{}]key={},value={}", ++i, entry.getKey(), entry.getValue());
        }
    }

    protected void logRes(Object res) {
        logger.debug("res={}", res);
    }

    protected void logResStringfy(Object res) {
        logger.debug("res={}", StringUtil.toString(res));
    }
}

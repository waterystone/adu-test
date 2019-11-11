package com.adu;

import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.BaseStream;

/**
 * @author yunjie.du
 * @date 2016/10/19 18:33
 */
public class BaseTest {
    // ADU

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void print(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.info("[{}]{}", ++i, stringfy(iterator.next()));
        }
    }

    protected void print(BaseStream stream) {
        Iterator iterator = stream.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.info("[{}]{}", ++i, stringfy(iterator.next()));
        }
    }

    protected <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            logger.info("[{}]{}", i + 1, stringfy(arr[i]));
        }
    }

    protected void print(Map<?, ?> map) {
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            logger.info("[{}]key={},value={}", ++i, stringfy(entry.getKey()), stringfy(entry.getValue()));
        }
    }

    protected void logRes(Object res) {
        logger.info("res={}", stringfy(res));
    }

    protected String stringfy(Object obj) {
        if (Objects.isNull(obj)) {
            return null;
        }
        // try {
        // if (obj.getClass().getDeclaredMethod("toString") != null) {//是否显式实现toString()
        // return obj.toString();
        // }
        // } catch (NoSuchMethodException e) {
        // }

        // return JsonUtil.toString(obj);
        //return StringUtil.toString(obj);
         return obj.toString();
    }

    protected void sleepUninterruptibly() {
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.HOURS);
    }

}

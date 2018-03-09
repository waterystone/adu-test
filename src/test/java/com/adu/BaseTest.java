package com.adu;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.BaseStream;

import com.adu.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.utils.StringUtil;

/**
 * @author yunjie.du
 * @date 2016/10/19 18:33
 */
public class BaseTest {
    //A
    //B
    //C

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void print(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.debug("[{}]{}", ++i, stringfy(iterator.next()));
        }
    }

    protected void print(BaseStream stream) {
        Iterator iterator = stream.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            logger.debug("[{}]{}", ++i, stringfy(iterator.next()));
        }
    }

    protected <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            logger.debug("[{}]{}", i + 1, stringfy(arr[i]));
        }
    }

    protected void print(Map<?, ?> map) {
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            logger.debug("[{}]key={},value={}", ++i, stringfy(entry.getKey()), stringfy(entry
                    .getValue()));
        }
    }


    protected void logRes(Object res) {
        logger.debug("res={}", stringfy(res));
    }


    protected String stringfy(Object obj) {
//        try {
//            if (obj.getClass().getDeclaredMethod("toString") != null) {//是否显式实现toString()
//                return obj.toString();
//            }
//        } catch (NoSuchMethodException e) {
//        }

        return JsonUtil.toString(obj);
        //return StringUtil.toString(obj);
    }

}

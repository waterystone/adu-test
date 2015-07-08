package com.adu.utils;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;

/*
* */
public class BeanConvertTool {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Log logger = LogFactory.getLog(BeanConvertTool.class);

    public static String toJson(Object object) {
        String res = null;
        try {
            res = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("[ERROR-toJson]", e);
        }
        return res;
    }

    public static <T> T toObject(Class<T> t, String s) {
        try {
            return objectMapper.readValue(s, t);
        } catch (Exception e) {
            logger.error("[ERROR-toObject]", e);
        }
        return null;
    }
}

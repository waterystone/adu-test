package com.adu.utils;

import javax.xml.bind.JAXBException;

import com.adu.bean.JsonBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.bean.XMLBean;

/**
 * @author: yunjie.du
 * @date: 2015/7/17 18:44
 */
public class JsonUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void toObject() throws JAXBException {
        String json = "{\n" + "    \"ResultCode\": 0,\n" + "    \"Students\": [{\n" + "        \"id\": 1,\n"
                + "        \"name\": \"zhangsan\",\n" + "        \"age\": 20\n" + "    },\n" + "    {\n"
                + "        \"id\": 2,\n" + "        \"name\": \"lisi\",\n" + "        \"age\": 18\n" + "    }]\n" + "}";
        JsonBean res = JsonUtil.toObject(json, JsonBean.class);
        logger.info(res.toString());
    }
}

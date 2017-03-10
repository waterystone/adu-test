package com.adu.utils;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.bean.JsonBean;
import com.adu.model.MyPerson;
import com.adu.model.Person;

/**
 * @author: yunjie.du
 * @date: 2015/7/17 18:44
 */
public class JsonUtilTest {
    private String json;
    private static final Logger logger = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void string2Object() throws JAXBException {
        JsonBean res = JsonUtil.toObject(json, JsonBean.class);
        logger.info(res.toString());
    }

    @Test
    public void toObject() {
        String json = "{\"name\":\"adu\",\"age\":20}";
        MyPerson res = JsonUtil.toObject(json, MyPerson.class);
        logger.info("res={}", res);
    }

    @Test
    public void prettyFormat() {
        //json = "{\"name\":\"adu\",\"age\":20}";
        String res = JsonUtil.prettyFormat(json);
        logger.info("res={}", res);
    }

    @Before
    public void init() {
        json = "{\n" + "    \"ResultCode\": 0,\n" + "    \"Students\": [{\n" + "        \"id\": 1,\n"
                + "        \"name\": \"zhangsan\",\n" + "        \"age\": 20\n" + "    },\n" + "    {\n"
                + "        \"id\": 2,\n" + "        \"name\": \"lisi\",\n" + "        \"age\": 18\n" + "    }]\n" + "}";
    }
}

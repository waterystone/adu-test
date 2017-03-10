package com.adu.org.zalando.zjsonpatch;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;

/**
 * @author yunjie.du
 * @date 2017/3/1 17:07
 */
public class JsonDiffTest extends BaseTest {
    private ObjectMapper jackson = new ObjectMapper();
    JsonNode beforeNode, afterNode;

    @Test
    public void asJson()  {
        JsonNode res = JsonDiff.asJson(beforeNode, afterNode);
        logRes(res);
    }

    @Before
    public void init() throws IOException {
        String beforeJson = "{\"a\":1,\"b\": [1,2],\"c\":2}";
        String afterJson = "{\"b\": [1,1,0]}";
        beforeNode = jackson.readTree(beforeJson);
        afterNode = jackson.readTree(afterJson);
    }

}

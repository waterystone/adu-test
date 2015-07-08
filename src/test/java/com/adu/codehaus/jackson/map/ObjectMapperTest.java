package com.adu.codehaus.jackson.map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class ObjectMapperTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final Log logger = LogFactory.getLog(this.getClass());

    @Test
    public void readValue() {
        String str = "{\"ticketNo\":\"WXHSNS8\"}";

    }
}

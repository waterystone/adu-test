package com.adu.jdk.util;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-12-11 23:18
 */
public class PropertiesTest extends BaseTest {
    @Test
    public void load() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("system.env"));
        logger.info("properties={}", properties);
    }
}

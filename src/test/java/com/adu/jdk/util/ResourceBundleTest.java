package com.adu.jdk.util;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2019-12-11 23:29
 */
public class ResourceBundleTest extends BaseTest {
    @Test
    public void getBundle() {
        ResourceBundle bundle = ResourceBundle.getBundle("system"); // 默认不加扩展名.properties

        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            logger.info("{}={}", key, bundle.getString(key));
        }
    }
}

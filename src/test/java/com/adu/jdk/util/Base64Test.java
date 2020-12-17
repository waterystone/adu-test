package com.adu.jdk.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2020-12-10 14:17
 */
public class Base64Test extends BaseTest {
    @Test
    public void encode() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("/Users/yunjie.du/Desktop/appeal/1268832839089049601.png"));
        String res = Base64.getEncoder().encodeToString(bytes);
        logRes(res);
    }
}

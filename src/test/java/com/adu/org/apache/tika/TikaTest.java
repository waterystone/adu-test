package com.adu.org.apache.tika;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.junit.Before;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2020-12-17 15:23
 */
public class TikaTest extends BaseTest {
    private Tika tika;
    private InputStream inputStream;

    @Test
    public void detect() throws IOException {
        String res = tika.detect(inputStream);
        logRes(res);

    }

    @Before
    public void init() {
        tika = new Tika();
        inputStream = this.getClass().getClassLoader().getResourceAsStream("picture/original.jpg");
    }
}

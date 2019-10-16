package com.adu.flickr4java.flickr;

import com.adu.BaseTest;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.test.TestInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

/**
 * @author duyunjie
 * @date 2019-10-16 10:58
 */
public class FlickrTest extends BaseTest {
    private Flickr flickr;

    @Before
    public void init() {
        String apiKey = "38b5b6afbb6a7f604cc6487ff07aec70";
        String sharedSecret = "68dd35927cd98e26";
        flickr = new Flickr(apiKey, sharedSecret, new REST());
    }

    @Test
    public void getTestInterface() throws FlickrException {
        TestInterface testInterface = flickr.getTestInterface();
        Collection res = testInterface.echo(Collections.EMPTY_MAP);
        logRes(res);
    }




}

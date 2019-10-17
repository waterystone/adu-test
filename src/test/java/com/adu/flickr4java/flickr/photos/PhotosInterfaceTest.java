package com.adu.flickr4java.flickr.photos;

import com.adu.BaseTest;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import org.junit.Before;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2019-10-17 10:33
 */
public class PhotosInterfaceTest extends BaseTest {
    private Flickr flickr;
    private PhotosInterface photosInterface;

    @Before
    public void init() {
        String apiKey = "38b5b6afbb6a7f604cc6487ff07aec70";
        String sharedSecret = "68dd35927cd98e26";
        flickr = new Flickr(apiKey, sharedSecret, new REST());
        photosInterface = flickr.getPhotosInterface();
    }

    @Test
    public void search() throws FlickrException {
        SearchParameters searchParameters = new SearchParameters();
        searchParameters.setBBox("116.06", "39.80", "116.65", "40.16");

        PhotoList<Photo> res = photosInterface.search(searchParameters, 10, 1);
        logRes(res);
    }
}

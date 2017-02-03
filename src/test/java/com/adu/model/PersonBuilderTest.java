package com.adu.model;

import java.util.Date;

import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/1/23 15:38
 */
public class PersonBuilderTest extends BaseTest {
    @Test
    public void build() {
        Person res = PersonBuilder.newBuilder().name("adu").age(30).birthDate(new Date()).build();
        logRes(res);
    }
}

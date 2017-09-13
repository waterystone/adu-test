package com.adu.org.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/9/13 下午5:47
 */
public class HashCodeBuilderTest extends BaseTest {
    private HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(17, 37);

    @Test
    public void toHashCode() {
        int res = hashCodeBuilder.append(111).append("adu").toHashCode();
        logRes(res);
    }
}

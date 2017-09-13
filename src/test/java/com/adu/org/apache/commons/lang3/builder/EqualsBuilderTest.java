package com.adu.org.apache.commons.lang3.builder;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;

import com.adu.BaseTest;

/**
 * @author yunjie.du
 * @date 2017/9/13 下午5:51
 */
public class EqualsBuilderTest extends BaseTest {
    private EqualsBuilder equalsBuilder = new EqualsBuilder();

    @Test
    public void isEquals() {
        boolean res = equalsBuilder.append(1, 1).append(true, true).append("adu", "adu").isEquals();
        logRes(res);
    }
}

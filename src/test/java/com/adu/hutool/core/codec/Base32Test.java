package com.adu.hutool.core.codec;

import cn.hutool.core.codec.Base32;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午7:08
 */
public class Base32Test extends BaseTest {
    @Test
    public void encode() {
        String res = Base32.encode("hello");
        logRes(res);
    }

    @Test
    public void decodeStr() {
        String res = Base32.decodeStr("NBSWY3DP");
        logRes(res);
    }
}

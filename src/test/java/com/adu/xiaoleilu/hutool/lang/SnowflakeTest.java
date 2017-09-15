package com.adu.xiaoleilu.hutool.lang;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.lang.Snowflake;
import org.junit.Test;

/**
 * @author yunjie.du
 * @date 2017/9/15 下午3:21
 */
public class SnowflakeTest extends BaseTest {
    private Snowflake snowflake=new Snowflake(1,1);

    @Test
    public void nextId() {
        long res = snowflake.nextId();
        logRes(res);
    }
}

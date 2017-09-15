package com.adu.xiaoleilu.hutool.date;

import java.util.Date;

import org.junit.Test;

import com.adu.BaseTest;
import com.xiaoleilu.hutool.date.DateTime;
import com.xiaoleilu.hutool.date.DateUtil;

/**
 * @author yunjie.du
 * @date 2017/9/15 下午2:46
 */
public class DateUtilTest extends BaseTest {
    @Test
    public void beginOfDay() {
        DateTime res = DateUtil.beginOfDay(new Date());
        logRes(res);
    }
}

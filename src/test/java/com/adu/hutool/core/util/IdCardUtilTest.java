package com.adu.hutool.core.util;

import cn.hutool.core.util.IdcardUtil;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:18
 */
public class IdCardUtilTest extends BaseTest {
    @Test
    public void getProvinceByIdCard() {
        String res = IdcardUtil.getProvinceByIdCard("411303197001011111");
        logRes(res);
    }
}

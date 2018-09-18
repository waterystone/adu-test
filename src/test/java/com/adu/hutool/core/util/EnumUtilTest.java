package com.adu.hutool.core.util;

import cn.hutool.core.util.EnumUtil;
import com.adu.BaseTest;
import com.adu.enums.MyEnum;
import org.junit.Test;

import java.util.Map;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:15
 */
public class EnumUtilTest extends BaseTest {
    @Test
    public void getNameFieldMap() {
        Map<String, Object> res = EnumUtil.getNameFieldMap(MyEnum.class, "code");
        logRes(res);
    }
}

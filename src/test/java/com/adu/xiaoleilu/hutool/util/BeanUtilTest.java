package com.adu.xiaoleilu.hutool.util;

import org.junit.Test;

import com.adu.BaseTest;
import com.adu.model.Person;
import com.xiaoleilu.hutool.util.BeanUtil;

import java.util.Map;

/**
 * @author yunjie.du
 * @date 2017/9/14 下午5:50
 */
public class BeanUtilTest extends BaseTest {
    private Person person = new Person("adu", 20);

    @Test
    public void beanToMap() {
        Map<String, Object> res = BeanUtil.beanToMap(person);
        logRes(res);
    }
}

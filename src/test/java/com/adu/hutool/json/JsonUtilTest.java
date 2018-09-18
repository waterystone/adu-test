package com.adu.hutool.json;

import cn.hutool.json.JSONUtil;
import com.adu.BaseTest;
import com.adu.model.Person;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:31
 */
public class JsonUtilTest extends BaseTest {
    private Person person = new Person("adu", 18);

    @Test
    public void toJsonStr() {
        String res = JSONUtil.toJsonStr(person);
        logRes(res);
    }
}

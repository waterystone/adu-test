package com.adu.hutool.system;

import cn.hutool.system.JavaSpecInfo;
import com.adu.BaseTest;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:40
 */
public class JavaSpecInfoTest extends BaseTest {
    private JavaSpecInfo javaSpecInfo = new JavaSpecInfo();

    @Test
    public void getName() {
        String res = javaSpecInfo.getName();
        logRes(res);
    }
}

package com.adu.hutool.system;

import cn.hutool.system.UserInfo;
import org.junit.Test;

import com.adu.BaseTest;

import cn.hutool.system.JavaInfo;
import cn.hutool.system.SystemUtil;

/**
 * @author duyunjie
 * @date 2018/9/18 下午8:45
 */
public class SystemUtilTest extends BaseTest {
    @Test
    public void getJavaInfo() {
        JavaInfo res = SystemUtil.getJavaInfo();
        logRes(res);
    }

    @Test
    public void getUserInfo() {
        UserInfo res = SystemUtil.getUserInfo();
        logRes(res);
    }
}

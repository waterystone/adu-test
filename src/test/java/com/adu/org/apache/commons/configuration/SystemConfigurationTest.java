package com.adu.org.apache.commons.configuration;

import org.apache.commons.configuration.SystemConfiguration;
import org.junit.Test;

import com.adu.BaseTest;

/**
 *
 * @author duyunjie
 * @date 2018/1/6 下午5:43 
 */
public class SystemConfigurationTest extends BaseTest {

    private SystemConfiguration systemConfiguration = new SystemConfiguration();

    @Test
    public void getString() {
        String res = systemConfiguration.getString("os.name");
        logRes(res);
    }
}

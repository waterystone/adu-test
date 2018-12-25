package com.adu.org.apache.commons.configuration;

import com.adu.BaseTest;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * @author duyunjie
 * @date 2018-12-25 15:41
 */
public class PropertiesConfigurationTest extends BaseTest {
    private PropertiesConfiguration propertiesConfiguration;

    @Test
    public void getString() {
        String res = propertiesConfiguration.getString("sys-env");
        logRes(res);
    }

    @Before
    public void init() throws ConfigurationException {
        // propertiesConfiguration = new PropertiesConfiguration("/opt/system.env");
        propertiesConfiguration = new PropertiesConfiguration(
                this.getClass().getClassLoader().getResource("system.env"));
    }
}

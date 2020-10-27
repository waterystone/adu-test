package com.adu.jdk.lang.management.mbean;

import com.adu.jdk.lang.management.mbean.HelloMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称
 * @author duyunjie
 * @date 2020-10-27 15:58
 */
public class Hello implements HelloMBean {
    private String name;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void hello() {
        logger.info("op=start_hello");
    }
}

package com.adu.jdk.lang.management.mbean;

/**
 * @author duyunjie
 * @date 2020-10-27 15:57
 */
public interface HelloMBean {
    String getName();

    void setName(String name);

    void hello();
}

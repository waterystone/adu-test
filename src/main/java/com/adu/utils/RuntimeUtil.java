package com.adu.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author yunjie.du
 * @date 2017/10/30 下午12:49
 */
public class RuntimeUtil {
    public static int getPid() {
        try {
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
            String name = runtime.getName(); // format: "pid@hostname"
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Throwable e) {
        }

        return 0;
    }

}

package com.adu.utils;

import org.apache.commons.lang3.StringUtils;

public class LogUtil {

    public static String generateLogStr(String objName, String params) {
        String prefix = "logger.info(\"op=method_start";
        String suffix = ");";
        StringBuffer buffer1 = new StringBuffer(), buffer2 = new StringBuffer();
        for (String param : params.split(",")) {
            buffer1.append(String.format(",%s={}", param));

            if (StringUtils.isEmpty(objName)) {
                buffer2.append(String.format(",%s", param));
            } else {
                buffer2.append(String.format(",%s.%s", objName, param));
            }
        }
        return prefix + buffer1 + "\"" + buffer2 + suffix;
    }
}

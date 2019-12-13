package com.adu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * jar包中版本相关的工具。
 * @author duyunjie
 * @date 2019-08-20 17:27
 */
public class VersionUtil {
    private static final Logger logger = LoggerFactory.getLogger(VersionUtil.class);

    /**
     * @param jarName1 要求jar名称必须是*-x.y.z(.|-)*的形式，x、y、z代表任意数字，且可以有多个。如abc-1.jar、abc-1.2.jar、abc-1.2.3.jar、abc-1.2.3.4.jar、abc-1.2.3-jre.jar.
     * @param jarName2 要求jar名称必须是*-x.y.z(.|-)*的形式，x、y、z代表任意数字，且可以有多个。如abc-1.jar、abc-1.2.jar、abc-1.2.3.jar、abc-1.2.3.4.jar、abc-1.2.3-jre.jar.
     * @return 0：相等；1：大于；-1：小于。
     */
    public static int compareVersion(String jarName1, String jarName2) {
        int res = 0;
        String version1 = extractVersion(jarName1);
        String version2 = extractVersion(jarName2);

        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                res = compare;
                break;
            }
        }

        logger.debug("op=end_compareVersion,jarName1={},jarName2={},version1={},version2={},res={}", jarName1, jarName2, version1, version2, res);
        return res;
    }

    //要求jar名称必须是*-x.y.z(.|-)*的形式，x、y、z代表任意数字，且可以有多个。如abc-1.jar、abc-1.2.jar、abc-1.2.3.jar、abc-1.2.3.4.jar、abc-1.2.3-jre.jar.
    private static final String VERSION_REGEX = "-((\\d+.)*\\d+)(\\.|-)";
    private static Pattern VERSION_PATTERN = Pattern.compile(VERSION_REGEX);

    /**
     * 抽取出jar包名称中的version
     *
     * @param jarName 要求jar名称必须是*-x.y.z(.|-)*的形式，x、y、z代表任意数字，且可以有多个。如abc-1.jar、abc-1.2.jar、abc-1.2.3.jar、abc-1.2.3.4.jar、abc-1.2.3-jre.jar.
     * @return
     */
    public static String extractVersion(String jarName) {
        Matcher matcher = VERSION_PATTERN.matcher(jarName);
        if (matcher.find()) {
            return matcher.group(1);
        }

        logger.error("[ERROR_extractVersion_illegal_param]jarName={}", jarName);
        throw new IllegalArgumentException(String.format("非法参数[%s]，无法用正则表达式\"%s\"提取版本，请检查！", jarName, VERSION_PATTERN));
    }
}

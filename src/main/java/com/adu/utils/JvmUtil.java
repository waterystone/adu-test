package com.adu.utils;

import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adu.concurrent.AbstractLazyInitializer;
import com.google.common.collect.Lists;

/**
 * JVM相关的工具
 * 
 * @author duyunjie
 * @date 2019/12/21 10:52 上午
 */
public class JvmUtil {
    private static final Logger logger = LoggerFactory.getLogger(JvmUtil.class);
    private static final AbstractLazyInitializer<Integer> LAZY_PID = new AbstractLazyInitializer<Integer>() {
        @Override
        protected Integer initialize() {
            return getPid0();
        }
    };

    /**
     * 获取JVM启动时间
     * 
     * @return
     */
    public static long getVmStartTime() {
        return ManagementFactory.getRuntimeMXBean().getStartTime();
    }

    /**
     * 获取JVM启动参数
     * 
     * @return
     */
    public static List<String> getVmArgs() {
        List<String> res = ManagementFactory.getRuntimeMXBean().getInputArguments();
        if (Objects.isNull(res)) {
            return Collections.emptyList();
        }

        return res;
    }

    /**
     * 获取PID
     * 
     * @return
     */
    public static int getPid() {
        return LAZY_PID.get();
    }

    private static int getPid0() {
        String name = ManagementFactory.getRuntimeMXBean().getName(); // format: "pid@hostname"
        try {
            return Integer.parseInt(name.substring(0, name.indexOf('@')));
        } catch (Exception e) {
            logger.error("[ERROR_getPid0]name={}", name, e);
        }

        return -1;
    }

    /**
     * 获取依赖的jar包路径
     * 
     * @return
     */
    public static List<String> getLibJarPaths() {
        URL[] libJarUrls = getLibJarUrls();
        List<String> res = Lists.newArrayListWithExpectedSize(libJarUrls.length);
        for (URL libJarUrl : libJarUrls) {
            res.add(libJarUrl.getPath());
        }

        return res;
    }

    /**
     * 获取依赖的jar包名称
     * 
     * @return
     */
    public static List<String> getLibJarNames() {
        URL[] libJarUrls = getLibJarUrls();
        List<String> res = Lists.newArrayListWithExpectedSize(libJarUrls.length);
        for (URL libJarUrl : libJarUrls) {
            res.add(extractLibJarName(libJarUrl));
        }

        return res;
    }

    private static URL[] getLibJarUrls() {
        ClassLoader classLoader = JvmUtil.class.getClassLoader();
        URLClassLoader webappClassLoader = (URLClassLoader) classLoader;
        return webappClassLoader.getURLs();
    }

    /**
     * 抽取出jar包名称
     * 
     * @param url
     * @return
     */
    private static String extractLibJarName(URL url) {
        String jarPath = url.getPath();
        if (jarPath == null || !jarPath.endsWith("jar")) {
            return null;
        }
        int lastIndexOfSeparator = jarPath.lastIndexOf("/");
        if (lastIndexOfSeparator < 0) {
            return jarPath;
        } else {
            return jarPath.substring(lastIndexOfSeparator + 1);
        }
    }

}

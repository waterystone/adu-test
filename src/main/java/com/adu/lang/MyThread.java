package com.adu.lang;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author duyunjie
 * @date 2018/9/19 下午2:18
 */
public class MyThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        String res = DateUtil.formatDateTime(new Date());
        logger.info("res={}", res);
    }
}

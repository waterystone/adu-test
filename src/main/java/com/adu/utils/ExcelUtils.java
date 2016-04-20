package com.adu.utils;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;


public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public static boolean exportExcel(Map<String, Object> dataElementMap, String templateFilePath, String resultFilePath) {
        boolean res = true;
        logger.info("op=exportExcel_start,templateFilePath={},resultFilePath={}", templateFilePath, resultFilePath);

        File resultFile = new File(resultFilePath);
        if (resultFile.exists()) {
            resultFile.delete();
        }

        Context context = new Context(dataElementMap);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(templateFilePath);
            outputStream = new FileOutputStream(resultFilePath);
            JxlsHelper.getInstance().processTemplate(inputStream, outputStream, context);
            outputStream.flush();
            logger.info("op=exportExcel_success,templateFilePath={},resultFilePath={}", templateFilePath, resultFilePath);
        } catch (Exception e) {
            logger.error("[ERROR-exportExcel]templateFilePath={},resultFilePath={}", templateFilePath, resultFilePath, e);
            res = false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {

                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {

                }

            }
        }
        return res;
    }

}

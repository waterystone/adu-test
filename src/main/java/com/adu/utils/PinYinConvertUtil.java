package com.adu.utils;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author duyunjie
 * @date 2019-12-03 11:09
 */
public class PinYinConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(PinYinConvertUtil.class);
    private static final HanyuPinyinOutputFormat DEFAULT_FORMAT = new HanyuPinyinOutputFormat();

    static {
        // 控制大小写
        // UPPERCASE：大写 (ZHONG)
        // LOWERCASE：小写 (zhong)
        DEFAULT_FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);

        // WITHOUT_TONE：无音标 (zhong)
        // WITH_TONE_NUMBER：1-4数字表示英标 (zhong4)
        // WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常） (zhòng)
        DEFAULT_FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        // WITH_V：用v表示ü (nv)
        // WITH_U_AND_COLON：用"u:"表示ü (nu:)
        // WITH_U_UNICODE：直接用ü (nü)
        DEFAULT_FORMAT.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
    }

    /**
     * 获得汉语拼音首字母
     *
     * @param chines 汉字
     * @return
     */
    public static String toFirstAlphas(String chines) {
        if (Objects.isNull(chines)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chines.length(); i++) {
            char chineseChar = chines.charAt(i);
            if (chineseChar > 128) {
                try {
                    builder.append(PinyinHelper.toHanyuPinyinStringArray(chineseChar, DEFAULT_FORMAT)[0].charAt(0));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    logger.error("[ERROR_getAlpha]chines={},chineseChar={}", chines, chineseChar, e);
                }
            } else {
                builder.append(chineseChar);
            }
        }

        return builder.toString();
    }

    /**
     * 将字符串中的中文转化为拼音,英文字符不变
     *
     * @param chines
     * @return
     */
    public static String toPingYins(String chines) {
        if (Objects.isNull(chines)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chines.length(); i++) {
            char chineseChar = chines.charAt(i);
            if (String.valueOf(chineseChar).matches("[\\u4E00-\\u9FA5]")) {
                try {
                    builder.append(PinyinHelper.toHanyuPinyinStringArray(chineseChar, DEFAULT_FORMAT)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    logger.error("[ERROR_getAlpha]chines={},chineseChar={}", chines, chineseChar, e);
                }
            } else {
                builder.append(chineseChar);
            }
        }

        return builder.toString();
    }
}

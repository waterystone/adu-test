package com.adu.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ning.compress.lzf.LZFDecoder;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.LZFException;

/**
 * 字符串压缩工具
 */
public class StringCompressUtil {
    private static final Logger logger = LoggerFactory.getLogger(StringCompressUtil.class);
    public static final Charset STRING_CHARSET = Charset.forName("UTF-8");

    /**
     * 压缩字符串，且base64编码
     * 
     * @param orig
     * @return
     */
    public static String compress(String orig) {
        if (orig == null) {
            return null;
        }

        return Base64.getEncoder().encodeToString((lzfCompress(orig.getBytes(STRING_CHARSET))));
    }

    /**
     * 先解base64编码，然后解压缩
     *
     * @param orig
     * @return
     * @throws LZFException
     * @throws UnsupportedEncodingException
     */
    public static String decompress(String orig) {
        if (orig == null) {
            return null;
        }
        try {
            return new String(lzfDecompress(Base64.getDecoder().decode(orig)), STRING_CHARSET);
        } catch (Exception e) {
            logger.error("解压订单快照失败.str={}", orig, e);
            throw new RuntimeException("解压订单快照失败.", e);
        }
    }

    private static byte[] lzfCompress(byte[] bytes) {
        return LZFEncoder.encode(bytes);
    }

    private static byte[] lzfDecompress(byte[] bytes) throws LZFException, UnsupportedEncodingException {
        return LZFDecoder.decode(bytes);
    }

}

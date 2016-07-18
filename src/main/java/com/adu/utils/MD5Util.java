package com.adu.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class MD5Util {

    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };


    public static String getMD5String(String s) {
        return getMD5String(s.getBytes(Charset.forName("utf-8")));
    }

    public static String getMD5String(byte[] bytes) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        messageDigest.update(bytes);
        return bufferToHex(messageDigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    /**
     * 获取指定参数转换为小写字母的16位md5加密
     * @param s 需要加密的消息
     * @return
     */
    public  static String get16Md5LowerString(String s) {
        try {
            return getMD5String(s.toLowerCase()).substring(8, 24);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean checkPassword(String password, String md5PwdStr) {
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

    public static String get16Md5LowerString(List<String> array) {

        StringBuffer convertString = new StringBuffer();
        for(String s : array){
            convertString.append(s);
        }
        return get16Md5LowerString(convertString.toString());
    }



}

package com.xxt.safe.hash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: con.xxt.safe.hash
 * @author: haytt.xiang
 * @date: 2020-09-13 17:53
 **/
public class DigestTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(md5("hello world"));
    }

    /**
     *
     * @param word
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5(String word) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(word.getBytes("utf-8"));
        //update方法可以在digest之前不断调用，追加需要签名的字符串内容
        md5.update(word.getBytes("utf-8"));
        byte[] digest = md5.digest();
        //将byte数组转为16进制字符串输出
        return new BigInteger(1, digest).toString(16);
    }




}

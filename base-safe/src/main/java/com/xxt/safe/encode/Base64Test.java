package com.xxt.safe.encode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @description: 将任意二进制数据转为纯文本
 * @author: haytt.xiang
 * @date: 2020-09-13 16:28
 **/
public class Base64Test {

    /**
     * @description: 读取文件内容为base64
     * @author: haytt.xiang
     * @date: 2020/9/13
     * @param
     * @return:
    */
    public static String fileToBase64(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] bytes=new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            return Base64.getEncoder().encodeToString(bytes);
        }
    }

    /**
     * 将base64内容写为文件
     * @param filePath
     * @param base64
     * @throws IOException
     */
    public static void base64ToFile(String filePath, String base64) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            byte[] decode = Base64.getDecoder().decode(base64);
            fileOutputStream.write(decode);
        }
    }

    /**
     * @description: 标准base64带有+等URL中不支持的符号，所以提供了一种url适用的base64编码
     * @author: haytt.xiang
     * @date: 2020/9/13
     * @param
     * @return:
     */
    public static String fileToUrlBase64(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            byte[] bytes=new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            return Base64.getUrlEncoder().encodeToString(bytes);
        }
    }

    /**
     * 将urlbase64内容写为文件
     * @param filePath
     * @param base64
     * @throws IOException
     */
    public static void urlBase64ToFile(String filePath, String base64) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            byte[] decode = Base64.getUrlDecoder().decode(base64);
            fileOutputStream.write(decode);
        }
    }

    public static void main(String[] args) throws IOException {
        //String base64 = fileToBase64("/Users/haytt.xiang/Documents/pik.jpg");
        //base64ToFile("/Users/haytt.xiang/Documents/newpik.jpg", base64);

        String urlBase64 = fileToUrlBase64("/Users/haytt.xiang/Documents/pik.jpg");
        urlBase64ToFile("/Users/haytt.xiang/Documents/urlpik.jpg", urlBase64);
    }
}

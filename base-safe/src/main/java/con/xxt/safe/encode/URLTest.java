package con.xxt.safe.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description: con.xxt.safe.encode
 * @author: haytt.xiang
 * @date: 2020-09-13 16:09
 **/
public class URLTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //url编码
        String encode = URLEncoder.encode("中文", StandardCharsets.UTF_8.displayName());
        System.out.println(encode);
        //url转码
        String decode = URLDecoder.decode(encode, StandardCharsets.UTF_8.displayName());
        System.out.println(decode);
    }
}

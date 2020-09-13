package con.xxt.safe.encode;

import java.nio.charset.Charset;

/**
 * @description: con.xxt.safe.encode
 * @author: haytt.xiang
 * @date: 2020-09-13 16:00
 **/
public class UnicodeTest {

    private static String charToUnicode(char s){
        return Integer.toHexString(s);
    }

    public static void main(String[] args) {
        System.out.println(charToUnicode('1'));
    }

}

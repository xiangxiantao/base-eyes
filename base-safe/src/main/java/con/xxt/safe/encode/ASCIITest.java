package con.xxt.safe.encode;

/**
 * @description: ASCII是一种常见的编码方式
 * @author: haytt.xiang
 * @date: 2020-09-13 15:52
 **/
public class ASCIITest {

    /**
     * @description: 字符转为其ASCII编码的字符串
     * @author: haytt.xiang
     * @date: 2020/9/13
     * @param
     * @return:
    */
    public static String charToASCIIString(char c){
        String ascii = String.valueOf((int)c);
        return ascii;
    }

    /**
     * @description: ascii字符串转为char
     * @author: haytt.xiang
     * @date: 2020/9/13
     * @param
     * @return:
    */
    public static char asciiStringToChar(String ascii){
        int i = Integer.parseInt(ascii);
        return (char)i;
    }

    public static void main(String[] args) {
        System.out.println(charToASCIIString('a'));
        System.out.println(asciiStringToChar("98"));
    }

}

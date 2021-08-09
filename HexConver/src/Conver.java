import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.UnsupportedEncodingException;

public class Conver {
    public static void main(String[] args) {
        System.out.println("十六进制"+strTo16("hhhhhfw34234325435345"));
        System.out.println("字符串"+hexStringToString(strTo16("hhhhhfw34234325435345")));
        System.err.println(HexBin.encode("fsidffmsldfmdkngslgnlk".getBytes()));
        System.err.println(new String(HexBin.decode(HexBin.encode("fsidffmsldfmdkngslgnlk".getBytes()))));
    }
    /**
     * 字符串转化成为16进制字符串
     * @param s
     * @return
     */
    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * 16进制转换成为string类型字符串
     * @param hexString
     * @return
     */
    public static String hexStringToString(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.replace(" ", "");
        byte[] baKeyword = new byte[hexString.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            hexString = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return hexString;
    }

    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = new byte[0];
        try {
            bs = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }
}

package com.xiaomo.timeMachine.core.util;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * │＼＿＿╭╭╭╭╭＿＿／│
 * │　　　　　　　　　│
 * │　　　　　　　　　│
 * │　－　　　　　　－│
 * │≡　　　　ｏ　≡   │
 * │　　　　　　　　　│
 * ╰——┬Ｏ◤▽◥Ｏ┬——╯
 * ｜　　ｏ　　｜
 * ｜╭－－－╮把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 15/9/6 16:05
 * @Description: * 此类中收集Java编程中WEB开发常用到的一些工具。
 * 注:为避免生成此类的实例，构造方法被申明为private类型的。
 * @Copyright(©) 2015 by xiaomo.
 */
public class EncodeUtil {

    private final static String[] hex = {"00", "01", "02", "03", "04", "05",
            "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B",
            "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26",
            "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31",
            "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C",
            "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47",
            "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52",
            "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D",
            "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68",
            "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73",
            "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E",
            "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
            "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94",
            "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F",
            "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA",
            "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5",
            "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB",
            "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6",
            "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1",
            "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC",
            "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7",
            "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};
    private final static byte[] val = {0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x00, 0x01,
            0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
            0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F};

    /**
     * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
     */
    private EncodeUtil() {
    }

    /** */

    /**
     * 对字符串编码
     *
     * @param s s
     * @return string
     */
    public static String encode(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                sb.append((char) ch);
            } else if ('a' <= ch && ch <= 'z') {
                sb.append((char) ch);
            } else if ('0' <= ch && ch <= '9') {
                sb.append((char) ch);
            } else if (ch == '-' || ch == '_' || ch == '.' || ch == '!'
                    || ch == '~' || ch == '*' || ch == '\'' || ch == '('
                    || ch == ')') {
                sb.append((char) ch);
            } else if (ch <= 0x007F) {
                sb.append('%');
                sb.append(hex[ch]);
            } else {
                sb.append('%');
                sb.append('u');
                sb.append(hex[(ch >>> 8)]);
                sb.append(hex[(0x00FF & ch)]);
            }
        }
        return sb.toString();
    }

    /** */
    /**
     * 对字符串解码
     *
     * @param s s
     * @return string
     */
    public static String decode(String s) {
        StringBuffer sbuf = new StringBuffer();
        int i = 0;
        int len = s.length();
        while (i < len) {
            int ch = s.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                sbuf.append((char) ch);
            } else if ('a' <= ch && ch <= 'z') {
                sbuf.append((char) ch);
            } else if ('0' <= ch && ch <= '9') {
                sbuf.append((char) ch);
            } else if (ch == '-' || ch == '_' || ch == '.' || ch == '!'
                    || ch == '~' || ch == '*' || ch == '\'' || ch == '('
                    || ch == ')') {
                sbuf.append((char) ch);
            } else if (ch == '%') {
                int cint = 0;
                if ('u' != s.charAt(i + 1)) {
                    cint = (cint << 4) | val[s.charAt(i + 1)];
                    cint = (cint << 4) | val[s.charAt(i + 2)];
                    i += 2;
                } else {
                    cint = (cint << 4) | val[s.charAt(i + 2)];
                    cint = (cint << 4) | val[s.charAt(i + 3)];
                    cint = (cint << 4) | val[s.charAt(i + 4)];
                    cint = (cint << 4) | val[s.charAt(i + 5)];
                    i += 5;
                }
                sbuf.append((char) cint);
            } else {
                sbuf.append((char) ch);
            }
            i++;
        }
        return sbuf.toString();
    }

    /**
     * 判断文件编码
     *
     * @param bis
     * @return
     */
    public static String getCharset(InputStream bis) {
        String charset = "GBK";
        try {

            int read;
            int loc = 0;

            while ((read = bis.read()) != -1) {
                loc++;
                if (read >= 0xF0)
                    break;
                if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                    break;
                if (0xC0 <= read && read <= 0xDF) {
                    read = bis.read();
                    if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)

                        continue;
                    else
                        break;
                } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                    read = bis.read();
                    if (0x80 <= read && read <= 0xBF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            charset = "UTF-8";
                            break;
                        } else
                            break;
                    } else
                        break;
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }

    /**
     * 对文件进行md5编码
     *
     * @param fileInputStream file
     * @return
     * @throws IOException
     */
    public static String getFileMD5(DataInputStream fileInputStream) throws IOException {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte buffer[] = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            fileInputStream.close();
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            fileInputStream.close();
        }
    }

    /**
     * <pre>
     * 例：
     * String strVal="This is a dog";
     * String strResult=CTools.replace(strVal,"dog","cat");
     * 结果：
     * strResult equals "This is cat"
     *
     * @param strSrc 要进行替换操作的字符串
     * @param strOld 要查找的字符串
     * @param strNew 要替换的字符串
     * @return 替换后的字符串
     * <pre>
     */
    public static final String replace(String strSrc, String strOld,
                                       String strNew) {
        if (strSrc == null || strOld == null || strNew == null)
            return "";

        int i = 0;

        if (strOld.equals(strNew)) //避免新旧字符一样产生死循环
            return strSrc;

        if ((i = strSrc.indexOf(strOld, i)) >= 0) {
            char[] arr_cSrc = strSrc.toCharArray();
            char[] arr_cNew = strNew.toCharArray();

            int intOldLen = strOld.length();
            StringBuilder buf = new StringBuilder(arr_cSrc.length);
            buf.append(arr_cSrc, 0, i).append(arr_cNew);

            i += intOldLen;
            int j = i;

            while ((i = strSrc.indexOf(strOld, i)) > 0) {
                buf.append(arr_cSrc, j, i - j).append(arr_cNew);
                i += intOldLen;
                j = i;
            }

            buf.append(arr_cSrc, j, arr_cSrc.length - j);

            return buf.toString();
        }

        return strSrc;
    }

    /**
     * 用于将字符串中的特殊字符转换成Web页中可以安全显示的字符串
     * 可对表单数据据进行处理对一些页面特殊字符进行处理如'<','>','"',''','&'
     *
     * @param strSrc 要进行替换操作的字符串
     * @return 替换特殊字符后的字符串
     * @since 1.0
     */

    public static String htmlTagEncode(String strSrc) {
        if (strSrc == null)
            return "";

        char[] arr_cSrc = strSrc.toCharArray();
        StringBuffer buf = new StringBuffer(arr_cSrc.length);
        char ch;

        for (int i = 0; i < arr_cSrc.length; i++) {
            ch = arr_cSrc[i];

            if (ch == '<')
                buf.append("&lt;");
            else if (ch == '>')
                buf.append("&gt;");
            else if (ch == '"')
                buf.append("&quot;");
            else if (ch == '\'')
                buf.append("&#039;");
            else if (ch == '&')
                buf.append("&amp;");
//                    以下无效
//            else if (ch == '©')
//                buf.append("&copy;");
//            else if (ch == '®')
//                buf.append("&reg;");
            else
                buf.append(ch);
        }

        return buf.toString();
    }

    /**
     * 用于将字符串中的特殊字符转换成Web页中可以安全显示的字符串
     * 可对表单数据据进行处理对一些页面特殊字符进行处理如'<','>','"',''','&'
     *
     * @param strSrc 要进行替换操作的字符串
     * @param quotes 为0时单引号和双引号都替换，为1时不替换单引号，为2时不替换双引号，为3时单引号和双引号都不替换
     * @return 替换特殊字符后的字符串
     * @since 1.0
     */
    public static String htmlTagEncode(String strSrc, int quotes) {

        if (strSrc == null)
            return "";
        if (quotes == 0) {
            return htmlTagEncode(strSrc);
        }

        char[] arr_cSrc = strSrc.toCharArray();
        StringBuffer buf = new StringBuffer(arr_cSrc.length);
        char ch;

        for (int i = 0; i < arr_cSrc.length; i++) {
            ch = arr_cSrc[i];
            if (ch == '<')
                buf.append("&lt;");
            else if (ch == '>')
                buf.append("&gt;");
            else if (ch == '"' && quotes == 1)
                buf.append("&quot;");
            else if (ch == '\'' && quotes == 2)
                buf.append("&#039;");
            else if (ch == '&')
                buf.append("&amp;");
            else
                buf.append(ch);
        }

        return buf.toString();
    }

    /**
     * 和htmlEncode正好相反
     *
     * @param strSrc 要进行转换的字符串
     * @return 转换后的字符串
     * @since 1.0
     */
    public static String htmlTagDecode(String strSrc) {
        if (strSrc == null)
            return "";
        strSrc = strSrc.replaceAll("&lt;", "<");
        strSrc = strSrc.replaceAll("&gt;", ">");
        strSrc = strSrc.replaceAll("&quot;", "\"");
        strSrc = strSrc.replaceAll("&#039;", "'");
        strSrc = strSrc.replaceAll("&amp;", "&");
//        以下无效
//        strSrc = strSrc.replaceAll("&copy;", "©");
//        strSrc = strSrc.replaceAll("™", "™");
//        strSrc = strSrc.replaceAll("&reg;", "®");
//        strSrc = strSrc.replaceAll("&times;", "×");
//        strSrc = strSrc.replaceAll("&divide;", "÷");
        return strSrc;
    }

    /**
     * 在将数据存入数据库前转换
     *
     * @param strVal 要转换的字符串
     * @return 从“ISO8859_1”到“utf-8”得到的字符串
     * @since 1.0
     */
    public static String ISOtoUTF8(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = strVal.trim();
                strVal = new String(strVal.getBytes("ISO8859_1"), "utf-8");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }

    /**
     * 编码转换 从UTF-8到GBK
     *
     * @param strVal
     * @return
     */
    public static String UTF8toGBK(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = strVal.trim();
                strVal = new String(strVal.getBytes("UTF-8"), "GBK");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }

    /**
     * 编码转换 从UTF-8到GBK
     *
     * @param strVal
     * @return
     */
    public static String GBKtoUTF8(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = strVal.trim();
                strVal = new String(strVal.getBytes("GBK"), "UTF-8");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }

    /**
     * 将数据从数据库中取出后转换   *
     *
     * @param strVal 要转换的字符串
     * @return 从“GBK”到“ISO8859_1”得到的字符串
     * @since 1.0
     */
    public static String GBKtoISO(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = new String(strVal.getBytes("GBK"), "ISO8859_1");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }

    /**
     * @param strVal
     * @return
     */
    public static String gbktoUTF8(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = new String(strVal.getBytes("GBK"), "UTF-8");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }

    public static String UTF8toISO(String strVal) {
        try {
            if (strVal == null) {
                return "";
            } else {
                strVal = new String(strVal.getBytes("UTF-8"), "ISO-8859-1");
                return strVal;
            }
        } catch (Exception exp) {
            return "";
        }
    }


    /**
     * 显示大文本块处理(将字符集转成ISO)
     *
     * @param str 要进行转换的字符串
     * @return 转换成html可以正常显示的字符串
     * @deprecated
     */
    public static String toISOHtml(String str) {
        return GBKtoISO(htmlTagDecode(nullToBlank((str))));
    }

    /**
     * 实际处理 return toChineseNoReplace(null2Blank(str));
     * 主要应用于老牛的信息发布
     *
     * @param str 要进行处理的字符串
     * @return 转换后的字符串
     */
    public static String toChineseAndHtmlEncode(String str, int quotes) {
        return htmlTagEncode(ISOtoUTF8(str), quotes);
    }

    /**
     * 把null值和""值转换成&nbsp;
     * 主要应用于页面表格格的显示
     *
     * @param str 要进行处理的字符串
     * @return 转换后的字符串
     */
    public static String str4Table(String str) {
        if (str == null)
            return "&nbsp;";
        else if (str.equals(""))
            return "&nbsp;";
        else
            return str;
    }

    /**
     * String型变量转换成int型变量
     *
     * @param str 要进行转换的字符串
     * @return intVal 如果str不可以转换成int型数据，返回-1表示异常,否则返回转换后的值
     * @since 1.0
     */
    public static int strToInt(String str) {
        int intVal;

        try {
            intVal = Integer.parseInt(str);
        } catch (Exception e) {
            intVal = 0;
        }

        return intVal;
    }

    public static double strToDouble(String str) {
        double dVal = 0;

        try {
            dVal = Double.parseDouble(str);
        } catch (Exception e) {
            dVal = 0;
        }

        return dVal;
    }


    public static long strToLong(String str) {
        long longVal = 0;

        try {
            longVal = Long.parseLong(str);
        } catch (Exception e) {
            longVal = 0;
        }

        return longVal;
    }

    public static float stringToFloat(String floatstr) {
        Float floatee;
        floatee = Float.valueOf(floatstr);
        return floatee;
    }

    //change the float type to the string type
    public static String floatToString(float value) {
        Float floatee = value;
        return floatee.toString();
    }

    /**
     *int型变量转换成String型变量
     *@param intVal 要进行转换的整数
     *@return str 如果intVal不可以转换成String型数据，返回空值表示异常,否则返回转换后的值
     */
    /**
     * int型变量转换成String型变量
     *
     * @param intVal 要进行转换的整数
     * @return str 如果intVal不可以转换成String型数据，返回空值表示异常,否则返回转换后的值
     */
    public static String intToStr(int intVal) {
        String str;

        try {
            str = String.valueOf(intVal);
        } catch (Exception e) {
            str = "";
        }

        return str;
    }

    /**
     * long型变量转换成String型变量
     *
     * @param longVal 要进行转换的整数
     * @return str 如果longVal不可以转换成String型数据，返回空值表示异常,否则返回转换后的值
     */

    public static String longToStr(long longVal) {
        String str;

        try {
            str = String.valueOf(longVal);
        } catch (Exception e) {
            str = "";
        }

        return str;
    }

    /**
     * null 处理
     *
     * @param str 要进行转换的字符串
     * @return 如果str为null值，返回空串"",否则返回str
     */
    public static String nullToBlank(String str) {
        if (str == null)
            return "";
        else
            return str;
    }

    /**
     * null 处理
     *
     * @param d 要进行转换的日期对像
     * @return 如果d为null值，返回空串"",否则返回d.toString()
     */

    public static String nullToBlank(Date d) {
        if (d == null)
            return "";
        else
            return d.toString();
    }

    /**
     * null 处理
     *
     * @param str 要进行转换的字符串
     * @return 如果str为null值，返回空串整数0,否则返回相应的整数
     */
    public static int nullToZero(String str) {
        int intTmp;
        intTmp = strToInt(str);
        if (intTmp == -1)
            return 0;
        else
            return intTmp;
    }

    /**
     * 把null转换为字符串"0"
     *
     * @param str
     * @return
     */
    public static String nullToSZero(String str) {
        str = EncodeUtil.nullToBlank(str);
        if (str.equals(""))
            return "0";
        else
            return str;
    }

    /**
     * sql语句 处理
     *
     * @param sql    要进行处理的sql语句
     * @param dbtype 数据库类型
     * @return 处理后的sql语句
     */
    public static String sql4DB(String sql, String dbtype) {
        if (!dbtype.equalsIgnoreCase("oracle")) {
            sql = EncodeUtil.GBKtoISO(sql);
        }
        return sql;
    }

    /**
     * 对字符串进行md5加密
     *
     * @param s 要加密的字符串
     * @return md5加密后的字符串
     */
    public final static String MD5(String s) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd',
                'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符串从GBK编码转换为Unicode编码
     *
     * @param text
     * @return
     */
    public static String StringToUnicode(String text) {
        String result = "";
        int input;
        StringReader isr;
        try {
            isr = new StringReader(new String(text.getBytes(), "GBK"));
        } catch (UnsupportedEncodingException e) {
            return "-1";
        }
        try {
            while ((input = isr.read()) != -1) {
                result = result + "&#x" + Integer.toHexString(input) + ";";

            }
        } catch (IOException e) {
            return "-2";
        }
        isr.close();
        return result;

    }

    /**
     * @param inStr
     * @return
     */
    public static String gbkToUTF8(String inStr) {
        char temChr;
        int ascInt;
        int i;
        String result = new String("");
        if (inStr == null) {
            inStr = "";
        }
        for (i = 0; i < inStr.length(); i++) {
            temChr = inStr.charAt(i);
            ascInt = temChr + 0;
            //System.out.println("1=="+ascInt);
            //System.out.println("1=="+Integer.toBinaryString(ascInt));
            if (Integer.toHexString(ascInt).length() > 2) {
                result = result + "&#x" + Integer.toHexString(ascInt) + ";";
            } else {
                result = result + temChr;
            }

        }
        return result;
    }

    /**
     * This method will encode the String to unicode.
     *
     * @param gbString
     * @return
     */

    //代码:--------------------------------------------------------------------------------
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }

    /**
     * This method will decode the String to a recognized String
     * in ui.
     *
     * @param dataStr
     * @return
     */
    public static StringBuffer decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer;
    }

    /**
     * 转换编码 ISO-8859-1到UTF-8
     *
     * @param text
     * @return
     */
    public static final String GBK2UTF8(String text) {
        String result = "";
        try {
            result = new String(text.getBytes("GBK"), "utf-8");
        } catch (UnsupportedEncodingException ex) {
            result = ex.toString();
        }
        return result;
    }

    /**
     * 转换编码 UTF-8到ISO-8859-1
     *
     * @param text
     * @return
     */
    public static final String GB2ISO(String text) {
        String result = "";
        try {
            result = new String(text.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Utf8URL编码
     *
     * @param text
     * @return
     */
    public static final String Utf8URLencode(String text) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            if (c >= 0 && c <= 255) {
                result.append(c);
            } else {

                byte[] b = new byte[0];
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                } catch (Exception ex) {
                }

                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    result.append("%" + Integer.toHexString(k).toUpperCase());
                }

            }
        }

        return result.toString();
    }

    /**
     * Utf8URL解码
     *
     * @param text
     * @return
     */
    public static final String Utf8URLdecode(String text) {
        String result = "";
        int p = 0;

        if (text != null && text.length() > 0) {
            text = text.toLowerCase();
            p = text.indexOf("%e");
            if (p == -1) return text;

            while (p != -1) {
                result += text.substring(0, p);
                text = text.substring(p, text.length());
                if (text == "" || text.length() < 9) return result;

                result += CodeToWord(text.substring(0, 9));
                text = text.substring(9, text.length());
                p = text.indexOf("%e");
            }

        }

        return result + text;
    }

    /**
     * utf8URL编码转字符
     *
     * @param text
     * @return
     */
    private static final String CodeToWord(String text) {
        String result;

        if (Utf8codeCheck(text)) {
            byte[] code = new byte[3];
            code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
            code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
            code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
            try {
                result = new String(code, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result = null;
            }
        } else {
            result = text;
        }

        return result;
    }

    /**
     * 编码是否有效
     *
     * @param text
     * @return
     */
    private static final boolean Utf8codeCheck(String text) {
        String sign = "";
        if (text.startsWith("%e"))
            for (int i = 0, p = 0; p != -1; i++) {
                p = text.indexOf("%", p);
                if (p != -1)
                    p++;
                sign += p;
            }
        return sign.equals("147-1");
    }

    /**
     * 判断是否Utf8Url编码
     *
     * @param text
     * @return
     */
    public static final boolean isUtf8Url(String text) {
        text = text.toLowerCase();
        int p = text.indexOf("%");
        if (p != -1 && text.length() - p > 9) {
            text = text.substring(p, p + 9);
        }
        return Utf8codeCheck(text);
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("/Users/xiaomo/workspace/LOL/core/src/main/java/com/xiaomo/lol/core/util/Dom4jHelper.java");
        String charset = getCharset(inputStream);
        String stest = "一声笑傲江湖之曲1234 abcd[]()<+>,.~\"";
        System.out.println(encode(stest));
        System.out.println(decode(encode(stest)));
    }


}

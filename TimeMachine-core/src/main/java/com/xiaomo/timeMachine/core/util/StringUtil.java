/**
 * 文 件 名:  StringUtil.java
 * 工 程 名:  MainServer
 * 创建日期:  2015年6月27日 下午7:39:50
 * 创建作者:  杨 强  <281455776@qq.com>
 */
package com.xiaomo.timeMachine.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 杨 强
 */
public class StringUtil {
    /**
     * 是否是空字符串
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 格式化字符串，如果没有对应的参数则按照原样输出
     * <p/>
     * <ul>
     * 例如:
     * <li>"获得{0}元宝,20"输出"获得20元宝"</li>
     * <li>"{0}获得{1}元宝,XX"输出"XX获得{1}元宝"</li>
     * <li>"{0}获得{1}元宝,XX,20"输出"XX获得20元宝"</li>
     * </ul>
     *
     * @param str
     * @param params
     * @return
     */
    public static String format(String str, Object... params) {
        if (isBlank(str)) {
            return str;
        }
        if (params == null || params.length == 0) {
            return str;
        }
        Pattern p = Pattern.compile("\\{(\\d+)\\}");
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String param = m.group();
            int index = Integer.parseInt(m.group(1));
            if (params.length > index) {
                Object obj = params[index];
                if (obj != null) {
                    param = obj.toString();
                }
            }
            m.appendReplacement(sb, param);
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 是否包含有HTML标签
     *
     * @param str
     * @return
     */
    public static boolean containsHTMLTag(String str) {
        if (StringUtil.isBlank(str)) {
            return false;
        }
        String pattern = "<\\s*(\\S+)(\\s[^>]*)?>[\\s\\S]*<\\s*\\/\\1\\s*>";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * String数组转成int数组
     *
     * @param numbers
     * @return
     */
    public static List<Integer> StringArrToIntList(String[] numbers) {
        List<Integer> intArr = new ArrayList<>();
        for (String number : numbers) {
            intArr.add(Integer.parseInt(number));
        }
        return intArr;
    }

    /**
     * String数组转成int数组
     *
     * @param numbers
     * @return
     */
    public static int[] StringArrToIntArr(String[] numbers) {
        int[] intArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            intArr[i] = Integer.parseInt(numbers[i]);
        }
        return intArr;
    }

    /**
     * 分割成list
     *
     * @param string 内容
     * @param symbol 符号
     * @return
     */
    public static List<String> split(String string, String symbol) {
        List<String> list = new ArrayList<>();
        String[] split = string.split(symbol);
        Collections.addAll(list, split);
        return list;
    }
}

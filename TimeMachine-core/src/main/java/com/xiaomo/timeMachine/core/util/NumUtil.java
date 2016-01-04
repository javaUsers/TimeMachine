package com.xiaomo.timeMachine.core.util;//package com.xiaomo.lol.core.util;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * │＼＿＿╭╭╭╭╭＿＿／│
// * │　　　　　　　　　│
// * │　　　　　　　　　│
// * │　－　　　　　　－│
// * │≡　　　　ｏ　≡   │
// * │　　　　　　　　　│
// * ╰——┬Ｏ◤▽◥Ｏ┬——╯
// * ｜　　ｏ　　｜
// * ｜╭－－－╮把今天最好的表现当作明天最新的起点．．～
// * いま 最高の表現 として 明日最新の始発．．～
// * Today the best performance  as tomorrow newest starter!
// * Created by IntelliJ IDEA.
// *
// * @author: xiaomo
// * @github: https://github.com/qq83387856
// * @email: hupengbest@163.com
// * @QQ_NO: 83387856
// * @Date: 15/9/6 16:05
// * @Description: ${todo}(用一句话描述该文件做什么)
// * @Copyright(©) 2015 by xiaomo.
// */
//public class NumUtil {
//
//    public static Double strToDouble(String s) {
//        Double ret = null;
//        if (s == null) return null;
//        try {
//            ret = Double.parseDouble(s);
//        } catch (Exception e) {
//
//        }
//        return ret;
//    }
//
//    public static Long strToLong(String s) {
//        Long ret = null;
//
//        if (s == null) return null;
//        try {
//            ret = Long.parseLong(s);
//        } catch (Exception e) {
//
//        }
//        return ret;
//
//    }
//
//    public static Integer strToInt(String s) {
//        Integer ret = null;
//        if (s == null) return null;
//        try {
//            ret = Integer.parseInt(s);
//        } catch (Exception e) {
//
//        }
//        return ret;
//
//    }
//
//    public static List<int[]> strsToInts(String num) {
//        if (num == null || num.equals("")) return null;
//        List<String> nums = StringUtil.split(num, '|');
//        List<int[]> ret = nums.stream().map(NumUtil::strToInts).collect(Collectors.toList());
//        return ret;
//    }
//
//    public static List<long[]> strsToLongs(String num) {
//        if (num == null || num.equals("")) return null;
//        List<String> nums = StringUtil.split(num, '|');
//        return nums.stream().map(NumUtil::strToLongs).collect(Collectors.toList());
//    }
//
//
//    public static int addInt(Number n1, Number n2) {
//        int i1 = 0;
//        if (n1 != null) i1 = n1.intValue();
//        int i2 = 0;
//        if (n2 != null) i2 = n2.intValue();
//        return i1 + i2;
//    }
//
//    /**
//     * 结果如果小于0，将变成0
//     *
//     * @param n1
//     * @param n2
//     * @return
//     */
//    public static int subIntNZ(Number n1, Number n2) {
//        int i1 = 0;
//        if (n1 != null) i1 = n1.intValue();
//        int i2 = 0;
//        if (n2 != null) i2 = n2.intValue();
//        int ret = i1 - i2;
//        if (ret < 0) ret = 0;
//        return ret;
//    }
//
//    /**
//     * 结果如果小于0，将变成0
//     *
//     * @param n1
//     * @param n2
//     * @return
//     */
//    public static int sub(Number n1, Number n2) {
//        int i1 = 0;
//        if (n1 != null) i1 = n1.intValue();
//        int i2 = 0;
//        if (n2 != null) i2 = n2.intValue();
//        int ret = i1 - i2;
//
//        return ret;
//    }
//
//    public static Integer isNull(Integer value) {
//        if (value == null) return 0;
//        return value;
//    }
//
//    private static int[] strToInts(String num) {
//        if (num == null || num.equals("")) return null;
//        String[] nums = num.split(",");
//        int[] ret = new int[nums.length];
//        for (int i = 0; i < ret.length; i++) {
//            ret[i] = Integer.parseInt(nums[i]);
//        }
//        return ret;
//    }
//
//    private static long[] strToLongs(String num) {
//        if (num == null || num.equals("")) return null;
//        List<String> nums = StringUtil.split(num, ',');
//        long[] ret = new long[nums.size()];
//        for (int i = 0; i < ret.length; i++) {
//            ret[i] = Long.parseLong(nums.get(i));
//        }
//        return ret;
//    }
//
//
//}

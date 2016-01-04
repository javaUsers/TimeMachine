package com.xiaomo.timeMachine.core.util;//package com.xiaomo.lol.core.util;
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
// * @Date: 15/9/6 17:42
// * @Description: ${todo}(用一句话描述该文件做什么)
// * @Copyright(©) 2015 by xiaomo.
// */
//public class Page {
//
//    public static final String DEFAULT_CHARSET = "utf-8";
//
//    public static int MAX_ROW = 10;
//    private int index;
//    private int page_num;
//    private int total;
//    private String url;
//
//    public Page(int index, int total, String url) {
//        this.index = index;
//        this.total = total;
//        this.url = url;
//        this.page_num = total % MAX_ROW == 0 ? total / MAX_ROW : total / MAX_ROW + 1;
//    }
//
//    public String getFooter() {
//        //不足一页 不显示分页信息
//        if (total <= MAX_ROW) {
//            return "";
//        }
//        StringBuffer sb = new StringBuffer("分页:");
//        //不足MAX_ROW页
//        if (page_num <= MAX_ROW) {
//            for (int i = 0; i < page_num; i++) {
//                insertTag(sb, i);
//            }
//            if (index + MAX_ROW < total) {
//                insertTag(sb, index + MAX_ROW, "下一页");
//            } else {
//                sb.append("下一页");
//            }
//            return sb.toString();
//        } else {
//            int unit = MAX_ROW * MAX_ROW;
//            if (index < unit) {
//                int i;
//                for (i = 0; i < MAX_ROW; i++) {
//                    insertTag(sb, i);
//                }
//                String tt = "下" + MAX_ROW + "页";
//                insertTag(sb, i * MAX_ROW, tt);
//                return sb.toString();
//            } else {
//                //当前页
//                int currentPage = index / MAX_ROW;
//                //当前面 一面有MAX_ROW页
//                int currentSection = currentPage / MAX_ROW + 1;
//                //上一面起始页
//                int lastPage = (currentSection - 1) * MAX_ROW - 1;
//                //上一面起始记录
//                int lastPageRow = lastPage * MAX_ROW;
//                //下一面起始页
//                int nextPage = currentSection * MAX_ROW;
//                //下一面起始记录
//                int nextPageRow = nextPage * MAX_ROW;
//                String tt = "上" + MAX_ROW + "页";
//
//                insertTag(sb, lastPageRow, tt);
//                //是否显示下一面
//                if (nextPageRow <= total - 1) {
//                    for (int i = 0; i < MAX_ROW; i++) {
//                        insertTag(sb, i + lastPage + 1);
//                    }
//                    tt = "下" + MAX_ROW + "页";
//                    insertTag(sb, nextPageRow, tt);
//                } else {
//                    int lengthOfPage = total - (lastPage + 1) * MAX_ROW;
//                    lengthOfPage = lengthOfPage / MAX_ROW + 1;
//                    for (int i = 0; i < lengthOfPage; i++) {
//                        insertTag(sb, i - 1 + lastPage);
//                    }
//                }
//                return EncodeUtil.GBK2UTF8(sb.toString());
//            }
//        }
//    }
//
//    public void insertTag(StringBuffer sb, int num) {
//        int temp = index / MAX_ROW;
//        if (num == temp) {
//            sb.append(num + 1).append("  ");
//        } else {
//            sb.append("<a href=").append(url).append("&start_index=");
//            sb.append(num * MAX_ROW).append(">").append(num + 1).append("</a>  ");
//        }
//    }
//
//    public void insertTag(StringBuffer sb, int num, String str) {
//        sb.append("<a href=" + url + "&start_index=");
//        sb.append(num).append(">").append(str).append("</a>  ");
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Page(120, 250, "http://www.baidu.com").getFooter());
//        //输出:   分页:上10页 11 12 13 14 15 16 17 18 19 20 下10页
//    }
//}

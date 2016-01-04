package com.xiaomo.TimeMachine.Test;//package com.xiaomo.lol.util;
//
//import com.xiaomo.lol.core.model.Equipment;
//import com.xiaomo.lol.core.model.Player;
//import com.xiaomo.lol.core.spider.duowan.DuowanClient;
//import com.xiaomo.lol.core.util.*;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.Date;
//import java.util.List;
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
// * @Date: 15/9/7 13:04
// * @Description: ${todo}(用一句话描述该文件做什么)
// * @Copyright(©) 2015 by xiaomo.
// */
//
//public class UtilTest extends BaseTest {
//
//    @Autowired
//    private DuowanClient client;
//
//    @Test
//    public void testDateUtil() throws ParseException {
//        String currentMonth = DateUtil.getCurrentMonth();
//        String dateFromNow = DateUtil.getDateFromNow(1);
//        String dateFormatFromNow = DateUtil.getDateFromNow(1, "yyyy-MM-dd HH:mm:ss");
//        String today = DateUtil.getToday();
//        String yestoday = DateUtil.getYestoday();
//        String s1 = DateUtil.convertDateToString(new Date());
//        Date date = DateUtil.convertStringToDate(s1);
//        int fri = DateUtil.getWeekNum("Fri");
//
//    }
//
//    @Test
//    public void testParse2Ints() {
//        String str = "1,2,3|4,6,7|909";
//        List<int[]> list = NumUtil.strsToInts(str);
//        for (int[] nums : list) {
//            System.out.println("nums.length=" + nums.length);
//            for (int num : nums) {
//                System.out.print(num);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
//
//
//    @Test
//    public void testLogger() {
//        Logger logger = LoggerUtil.getLogger(UtilTest.class);
//        try {
//            int a = 10;
//            int b = 4;
//            int c = a / b;
//            logger.info("结果为:" + c);
//        } catch (Exception e) {
//            logger.info("error-----> {}", e.getMessage());
//        }
//    }
//
//    @Test
//    public void testName() {
//        String s = NameUtil.buildName(Player.class, "Controller");
//        System.out.println(s);
//    }
//
//    @Test
//    public void testDate() {
//        String date = DateUtil.getDate(new Date());
//        final String timeNow = DateUtil.getFormatTime(new Date());
//        int i = DateUtil.diffDate("2015-09-05", DateUtil.getDateTime(new Date(), DateUtil.datePattern));
//        long timeStamp = DateUtil.getTimeStamp(DateUtil.timePattern, "2015-09-01 09:11:23");
//    }
//
//    @Test
//    public void testSerialize() throws IOException {
//        List<Equipment> list = client.fetchEquipment();
//        String serialize = SerializeUtil.serialize(list);
//        System.out.println(serialize);
//    }
//
//}

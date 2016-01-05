package com.xiaomo.timeMachine.core.constant;

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
 * @Date: 15/9/6 17:09
 * @Description: 通用常量类
 * @Copyright(©) 2015 by xiaomo.
 */
public class Cconst {

    /**
     * 网站图片目录
     */
    public final static String PIC_ROOT = "/pic/";
    /**
     * 网站软件目录
     */

    public final static String SOFT_ROOT = "/soft/";
    /**
     * 附件文件存放的绝对路径
     */

    public final static String ATTACH_ROOT = "/attach/";
    /**
     * 动态程序路径
     */

    public final static String ProgramPath = "/programs/";
    /**
     * 上传图片大小限制，单位byte
     */
    public final static long MAX_UPLOAD_PIC_SIZE = 1000 * 1024 * 4;
    /**
     * 上传文件大小限制，单位byte
     */
    public final static long MAX_UPLOAD_FILE_SIZE = 10 * 1024 * 1024 * 8;
    /**
     * 上传软件大小限制，单位byte
     */
    public final static long MAX_UPLOAD_SOFT_SIZE = 100 * 1024 * 1024 * 8;
    /**
     * 错误登录次数最多3次
     */
    public final static int MAX_LOGIN_TIMES = 3;
    /**
     * 错误登录3次后用户被锁10分钟
     */
    public final static int LOCK_TIME = +10;
    public final static String[] ADMIN = {"xiaomo", "xiaomo"};
    /**
     * 中文超大字符集
     */
    public static String GBK;
    /**
     * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
     */
    public static String ISO_8859_1;
    /**
     * 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
     */
    public static String US_ASCII;
    /**
     * 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
     */
    public static String UTF_16;
    /**
     * 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序
     */
    public static String UTF_16BE;
    /**
     * 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序
     */
    public static String UTF_16LE;
    /**
     * 8 位 UCS 转换格式
     */
    public static String UTF_8;

}

package com.xiaomo.timeMachine.core.util;

import org.slf4j.Logger;

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
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Copyright(©) 2015 by xiaomo.
 */
public interface LoggerHelper {

    default void DEBUG(Logger logger, String mark, Object... data) {
        if (logger.isDebugEnabled()) {
            logger.debug(mark, data);
        }
    }

    default void INFO(Logger logger, String mark, Object... data) {
        if (logger.isInfoEnabled()) {
            logger.info(mark, data);
        }
    }

    default void ERROR(Logger logger, String mark, Object... data) {
        if (logger.isErrorEnabled()) {
            logger.error(mark, data);
        }
    }


}

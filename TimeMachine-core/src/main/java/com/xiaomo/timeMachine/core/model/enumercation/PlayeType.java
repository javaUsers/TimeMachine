package com.xiaomo.timeMachine.core.model.enumercation;

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
 * @Date: 15/9/6 15:27
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Copyright(©) 2015 by xiaomo.
 */
public enum PlayeType {
    AP("AP"), AD("AD");

    private String display;

    PlayeType(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return this.display;
    }
}

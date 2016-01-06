package com.xiaomo.timeMachine.core.api;

import com.alibaba.fastjson.JSONObject;
import com.xiaomo.timeMachine.core.constant.OauthType;
import com.xiaomo.timeMachine.core.constant.QQUserField;
import com.xiaomo.timeMachine.core.model.QQUser;

import java.util.Date;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 13:28 2016/1/6
 * @Description: todo
 * @Copyright(©) 2015 by xiaomo.
 */
public class OauthApi {

    /**
     * 将获取到的json数据转成用户实体类
     *
     * @param o json
     * @return QQUser
     */
    public static QQUser getQQUser(JSONObject o) {
        QQUser user = new QQUser();
        String url = o.getString(QQUserField.figureurl);
        String nickname = o.getString(QQUserField.nickname);
        String openId = o.getString(QQUserField.openid);
        String gender = o.getString(QQUserField.gender);
        String year = o.getString(QQUserField.year);
        String address = o.getString(QQUserField.province) + " " + o.getString(QQUserField.city);
        user.setCreateTime(new Date());
        user.setHeadPhoto(url);
        user.setNickName(nickname);
        user.setGender(gender);
        user.setYear(year);
        user.setOpenId(openId);
        user.setType(OauthType.qq);
        user.setAddress(address);
        return user;
    }
}

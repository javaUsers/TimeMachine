package com.xiaomo.timeMachine.core.service.impl;

import com.xiaomo.timeMachine.core.dao.oauth.QQUserDao;
import com.xiaomo.timeMachine.core.model.QQUser;
import com.xiaomo.timeMachine.core.service.QQUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @Date: 2016/1/4 19:43
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Copyright(©) 2015 by xiaomo.
 */
@Service
public class UserServiceImpl implements QQUserService {

    @Autowired
    private QQUserDao qqUserDao;

    @Override
    public boolean saveUserData(QQUser userInfo) {
        try {
            qqUserDao.save(userInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

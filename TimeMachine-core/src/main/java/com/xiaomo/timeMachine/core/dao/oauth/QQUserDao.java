package com.xiaomo.timeMachine.core.dao.oauth;

import com.xiaomo.timeMachine.core.model.QQUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
 * @Date: 13:24 2016/1/6
 * @Description: QQ登录Dao
 * @Copyright(©) 2015 by xiaomo.
 */
@Repository
public interface QQUserDao extends JpaRepository<QQUser, Long> {

}

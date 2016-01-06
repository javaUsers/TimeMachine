package com.xiaomo.timeMachine.web.controller.openLogin;

import com.alibaba.fastjson.JSONObject;
import com.xiaomo.timeMachine.core.api.OauthApi;
import com.xiaomo.timeMachine.core.model.QQUser;
import com.xiaomo.timeMachine.core.oauth.OauthQQ;
import com.xiaomo.timeMachine.core.service.QQUserService;
import com.xiaomo.timeMachine.core.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 把今天最好的表现当作明天最新的起点..
 * いま最高の表现として明日最新の始発..
 *
 * @author：小莫(83387856)
 * @github：https://github.com/qq83387856
 * @Email：hupengbest@163.com
 * @date: 2015/11/23 16:55
 * @描述：第三方登录
 **/
@RestController
@RequestMapping("/api")
public class AuthLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthLoginController.class);

    @Autowired
    private QQUserService qqUserService;

    /**
     * QQ 登录
     *
     * @param response response
     * @throws IOException
     */
    @RequestMapping(value = "/qq", method = RequestMethod.GET)
    public void login(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        try {
            String authorizeUrl = OauthQQ.getInstance().getAuthorizeUrl(TokenUtil.randomState());
            response.sendRedirect(authorizeUrl);
        } catch (IOException e) {
            LOGGER.error("获取授权url出错了,{}", e);
            response.sendRedirect("/");
        }
    }

    /**
     * @param response response
     * @param code     code
     * @return String url
     */
    @RequestMapping(value = "/qq/callback", method = RequestMethod.GET)
    public void callbackQQ(HttpServletResponse response, String code) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        JSONObject userInfo = null;
        try {
            userInfo = OauthQQ.getInstance().getUserInfoByCode(code);
            QQUser qQuser = OauthApi.getQQUser(userInfo);
            boolean saved = qqUserService.saveUserData(qQuser);
            if (saved) {
                LOGGER.info("新用户[{}]登录成功且己存储");
            } else {
                LOGGER.error("数据库出现异常");
            }
        } catch (Exception e) {
            LOGGER.error("OauthBaidu error" + e.getMessage());
        }
    }

}

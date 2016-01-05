package com.xiaomo.timeMachine.web.controller.openLogin;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/qq")
public class QQLoginController {

    /**
     * QQ 登录
     *
     * @param request  request
     * @param response response
     * @throws IOException
     */
    @RequestMapping("/toLogin")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        Oauth oauth = new Oauth();
        try {
            String url = oauth.getAuthorizeURL(request);
            response.sendRedirect(url);
        } catch (QQConnectException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回调
     *
     * @param request  request
     * @param response response
     * @return UserInfoBean
     */
    @RequestMapping("callbackLogin")
    public UserInfoBean callbackLogin(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
        response.setContentType("text/html; charset=utf-8");
        try {
            AccessToken qqtoken = new Oauth().getAccessTokenByRequest(request);
            if (qqtoken.getAccessToken().equals("")) {
                return null;
            } else {
                String accessToken = qqtoken.getAccessToken();
                OpenID oId = new OpenID(accessToken);
                String openid = oId.getUserOpenID();
//                Long tokenExpireIn = qqtoken.getExpireIn();
//                session.setAttribute("access_token", accessToken);
//                session.setAttribute("token_expirein", String.valueOf(tokenExpireIn));
//                session.setAttribute("openid", openid);
                UserInfo userinfo = new UserInfo(accessToken, openid);
                UserInfoBean userInfo = userinfo.getUserInfo();
                return userInfo;
            }
        } catch (QQConnectException e) {
            e.printStackTrace();
            return null;
        }
    }

}

package com.xiaomo.timeMachine.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
 * @Description: HttpClient公共工具类
 * @Copyright(©) 2015 by xiaomo.
 */
public class HttpClientUtil {
    private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * post请求
     *
     * @param url      url
     * @param paramMap map
     */
    public static String post(String url, Map<String, String> paramMap) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        List<NameValuePair> formParams = createFormParams(paramMap);
        UrlEncodedFormEntity uefEntity;
        String result = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httppost.setEntity(uefEntity);
            log.info("httpClient请求地址【" + httppost.getURI() + "】");
            CloseableHttpResponse response = httpclient.execute(httppost);
            result = parseResult(response);
            log.info("远程调用地址【" + url + "】;返回结果:" + result);
        } catch (Exception e) {
            log.info("client远程调用出现异常：", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                log.info("httpclient.close()关闭的时候出现异常：", e);
            }
        }
        return result;
    }


    /**
     * get请求
     *
     * @param url url
     * @return string
     */
    public static String get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String result = null;
        try {
            HttpGet httpget = new HttpGet(url);
            log.info("executing request " + httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            result = parseResult(response);
            log.info("远程调用地址【" + url + "】;返回结果:" + result);
        } catch (IOException e) {
            log.info("远程调用出现异常：", e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                log.info("httpclient.close()关闭出现异常:", e);
            }
        }
        return result;
    }

    /**
     * 解析结果
     *
     * @param response
     * @return
     */
    private static String parseResult(CloseableHttpResponse response) {
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
                log.info("Response content: " + result);
            }
        } catch (Exception e) {
            log.info("解析结果出现异常【】", e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                log.info("response.close()出现异常：", e);
            }
        }
        return result;
    }

    /**
     * 创建参数集
     *
     * @param paramMap
     * @return
     */
    private static List<NameValuePair> createFormParams(Map<String, String> paramMap) {
        if (null == paramMap) {
            return Collections.emptyList();
        }
        List<NameValuePair> formParams = paramMap.entrySet().stream().map(entry ->
                new BasicNameValuePair(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return formParams;
    }

}

package com.xiaomo.timeMachine.core.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

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
 * @Date: 2016/1/5 20:05
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Copyright(©) 2015 by xiaomo.
 */
public class URLUtil {
    private static HttpClient httpClient = new HttpClient();

    /**
     * @param strURL 要访问的URL地址
     * @param param  参数
     * @return 结果字符串
     * @throws Exception
     * @Title: getDataFromURL
     * @Description: 根据URL跨域获取输出结果，支持http
     */
    public static String getDataFromURL(String strURL, Map<String, String> param) throws Exception {
        URL url = new URL(strURL);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        final StringBuilder sb = new StringBuilder(param.size() << 4); // 4次方
        final Set<String> keys = param.keySet();
        for (final String key : keys) {
            final String value = param.get(key);
            sb.append(key); // 不能包含特殊字符
            sb.append('=');
            sb.append(value);
            sb.append('&');
        }
        // 将最后的 '&' 去掉
        sb.deleteCharAt(sb.length() - 1);
        writer.write(sb.toString());
        writer.flush();
        writer.close();

        InputStreamReader reder = new InputStreamReader(conn.getInputStream(), "utf-8");
        BufferedReader breader = new BufferedReader(reder);
        // BufferedWriter w = new BufferedWriter(new FileWriter("d:/1.txt"));
        String content = null;
        String result = null;
        while ((content = breader.readLine()) != null) {
            result += content;
        }

        return result;
    }

    /**
     * @param url     要访问的URL地址(http://www.xxx.com?)
     * @param urlParm 参数(id=1212&pwd=2332)
     * @return 结果字符串
     * @Title: postMethod
     * @Description: 根据URL跨域获取输出结果，支持https
     */
    public static String postMethod(String url, String urlParm) {
        if (null == url || "".equals(url)) {
            // url = "http://www.baidu.com";
            return null;
        }
        PostMethod post = new PostMethod(url); // new UTF8PostMethod(url);
        if (null != urlParm && !"".equals(urlParm)) {
            String[] arr = urlParm.split("&");
            NameValuePair[] data = new NameValuePair[arr.length];
            for (int i = 0; i < arr.length; i++) {
                String name = arr[i].substring(0, arr[i].lastIndexOf("="));
                String value = arr[i].substring(arr[i].lastIndexOf("=") + 1);
                data[i] = new NameValuePair(name, value);
            }
            post.setRequestBody(data);
        }
        int statusCode = 0;
        String pageContent = "";
        try {
            statusCode = httpClient.executeMethod(post);
            if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
                pageContent = post.getResponseBodyAsString();
                return pageContent;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            post.releaseConnection();
        }
        return null;
    }

    public static String doPost(String url, String json) throws Exception {
        PostMethod postMethod = new PostMethod(url);
        StringRequestEntity requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
        postMethod.setRequestEntity(requestEntity);
        /* 发送请求，并获取响应对象 */
        int statusCode = httpClient.executeMethod(postMethod);
        String result = null;
        if (statusCode == HttpStatus.SC_OK) {
            result = postMethod.getResponseBodyAsString();
        } else {
            System.out.println("Method failed: " + postMethod.getStatusLine());
        }
        return result;
    }

    public static String post(String url, Map<String, String> params) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        String body = null;
        HttpPost post = postForm(url, params);
        body = invoke(httpclient, post);
        httpclient.getConnectionManager().shutdown();
        return body;
    }

    private static HttpPost postForm(String url, Map<String, String> params) {
        HttpPost httpost = new HttpPost(url);
        List<BasicNameValuePair> nvps = new ArrayList<>();
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key, params.get(key));
            nvps.add(basicNameValuePair);
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpost;
    }

    private static String invoke(DefaultHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = sendRequest(httpclient, httpost);
        return paseResponse(response);
    }

    private static HttpResponse sendRequest(DefaultHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private static String paseResponse(HttpResponse response) {
        HttpEntity entity = response.getEntity();
        String body = null;
        try {
            body = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void getAjaxData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "*");//'*'表示允许所有域名访问，可以设置为指定域名访问，多个域名中间用','隔开
        //如果IE浏览器则设置头信息如下
        if ("IE".equals(request.getParameter("type"))) {
            response.addHeader("XDomainRequestAllowed", "1");
        }
    }


    public static void main(String[] args) throws Exception {
        String url = "http://ip:8082/security/auth/outside.do";
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginName", "root");
        map.put("code", "vms2.0");
        String msg = post(url, map);
        JSONArray jary = JsonUtil.Json2JSONArray(msg);
        for (int i = 0; i < jary.size(); i++) {
            JSONObject obj = jary.getJSONObject(i);
            System.out.println(obj);
//          System.out.print(obj.getString("classid"));
//          System.out.print("\t"+obj.getString("classname"));
//          System.out.println("\t"+obj.getString("sonclass"));
        }
//      System.out.println(jary);
    }
}

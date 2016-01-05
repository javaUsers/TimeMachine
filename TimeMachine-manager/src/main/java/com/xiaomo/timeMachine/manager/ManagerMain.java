package com.xiaomo.timeMachine.manager;

import com.xiaomo.timeMachine.core.factory.HttpClientFactory;
import org.apache.http.client.HttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
 * @Date: 15/9/2 17:43
 * @Description: ip:port(localhost:8888) 打开后显示 spring boot has started!
 * @Copyright(©) 2015 by xiaomo.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.xiaomo.timeMachine")
@EntityScan("com.xiaomo.timeMachine.*.model")
@EnableTransactionManagement
@EnableJpaRepositories("com.xiaomo.timeMachine.*.dao")
public class ManagerMain extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManagerMain.class, args);
    }

    @Bean
    public HttpClient httpClient() {
        return new HttpClientFactory().getObject();
    }
}

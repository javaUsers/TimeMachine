package com.xiaomo.TimeMachine.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaomo.timeMachine.core.factory.HttpClientFactory;
import com.xiaomo.timeMachine.core.factory.ObjectMapperBeanFactory;
import org.apache.http.client.HttpClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.xiaomo.timeMachine")
@EntityScan("com.xiaomo.timeMachine.*.bean")
@EnableTransactionManagement
@EnableJpaRepositories("com.xiaomo.timeMachine.*.dao")
public class TestConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperBeanFactory().getObject();
    }

    @Bean
    public HttpClient httpClient() {
        return new HttpClientFactory().getObject();
    }

}
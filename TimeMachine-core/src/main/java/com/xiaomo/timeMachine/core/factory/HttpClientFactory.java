package com.xiaomo.timeMachine.core.factory;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.FactoryBean;

public class HttpClientFactory implements FactoryBean<HttpClient> {

    @Override
    public HttpClient getObject() {
        return HttpClientBuilder.create().build();
    }

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}

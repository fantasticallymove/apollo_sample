package com.apollo.apollo_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 此服務拿來使用Spring提供的Value測試注入
 */
@Component
public class PropertiesService {
    @Value("${timeout}")
    private String timeout;

    public PropertiesService() {
    }

    public String getTimeout(){
        return timeout;
    }
}

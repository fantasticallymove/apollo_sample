package com.apollo.apollo_demo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * 以下兩個系統參數記得加上
 * 第一個是對應到你要指定的appId 在apollo上
 * 第二個是對應apollo 啟動後會使用8080啟動eurekaServer 它將會做config 確認用, 當沒有設定時會使用預設 http://apollo.mete/
 * 假設沒做host 會報錯 所以直接使用以下系統參數加上後解決
 * -Dapp.id=SampleApp -Dapollo.meta=http://localhost:8080
 *
 * 另外META-INF 資料夾一定要手動加上 並加入app.properties檔案指定appId
 */
@Configuration
@EnableApolloConfig
@RestController
public class ApolloConfig {
    private final Config appConfig;
    public ApolloConfig() {
        appConfig = ConfigService.getAppConfig();

        /**
         * 這端將監聽apollo 配置於apollo server上刷新 將會收到通知
         */
        appConfig.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                System.out.println("Changes for namespace " + changeEvent.getNamespace());
                for (String key : changeEvent.changedKeys()) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.println(MessageFormat.format(
                            "Found change - key: {0}, oldValue: {1}, newValue: {2}, changeType: {3}",
                            change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
                }
            }
        });
        String value = appConfig.getProperty("timeout", "default");
        System.out.println(value);
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok(appConfig.getProperty("timeout", "default"));
    }
}

package com.lourice.ein.weather.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:weather.properties")
@ConfigurationProperties
public class WeatherProperties {

    private String providerBaseUrl;
    private String restVersion;
    private String restAction;
    private String appId;

    public String getProviderUrl(){
        StringBuilder sb = new StringBuilder();
        sb.append(providerBaseUrl)
                .append(restVersion)
                .append("/")
                .append(restAction)
                .append("?APPID=")
                .append(appId);
        return sb.toString();
    }

    public void setProviderBaseUrl(String providerBaseUrl) {
        this.providerBaseUrl = providerBaseUrl;
    }

    public void setRestVersion(String restVersion) {
        this.restVersion = restVersion;
    }

    public void setRestAction(String restAction) {
        this.restAction = restAction;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

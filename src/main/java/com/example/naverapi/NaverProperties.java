package com.example.naverapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "naver")
public class NaverProperties {
    @Getter @Setter private String url;
    @Getter @Setter private String clientId;
    @Getter @Setter private String clientSecret;
}

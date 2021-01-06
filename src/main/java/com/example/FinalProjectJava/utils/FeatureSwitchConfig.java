package com.example.FinalProjectJava.utils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("feature-operation")
public class FeatureSwitchConfig {
    public boolean mathOperationOn;
}

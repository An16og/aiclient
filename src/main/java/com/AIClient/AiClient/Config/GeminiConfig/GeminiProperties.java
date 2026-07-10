package com.AIClient.AiClient.Config.GeminiConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai.gemini")
@Getter
@Setter
public class GeminiProperties {
    private String apiKey;
    private String model;

}
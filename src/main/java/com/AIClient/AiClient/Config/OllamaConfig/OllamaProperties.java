package com.AIClient.AiClient.Config.OllamaConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai.ollama")
@Getter
@Setter
public class OllamaProperties {
    private String BaseUrl;
    private String model;

}
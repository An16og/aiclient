package com.AIClient.AiClient.Config.OllamaConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OllamaResponse {

    private String model;
    private String time;
    private String response;
    private boolean done;
}

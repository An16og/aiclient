package com.AIClient.AiClient;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class AiResponse {
    private String response;
    private String model;
    private String provider;
}

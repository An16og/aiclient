package com.AIClient.AiClient.Provider;

import com.AIClient.AiClient.AiResponse;
import com.AIClient.AiClient.Config.OllamaConfig.OllamaProperties;
import com.AIClient.AiClient.Config.OllamaConfig.OllamaRequest;
import com.AIClient.AiClient.Config.OllamaConfig.OllamaResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class OllamaAiProvider implements AiProvider {

    private final OllamaProperties properties;
    private final RestClient restClient;

    public OllamaAiProvider(OllamaProperties properties) {
        this.properties = properties;

        this.restClient = RestClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();
    }

    @Override
    public AiResponse response(String prompt) {

        OllamaRequest request = new OllamaRequest(
                properties.getModel(),
                prompt,
                false
        );

        OllamaResponse response = restClient.post()
                .uri("/api/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OllamaResponse.class);

        return AiResponse.builder()
                .response(response.getResponse())
                .provider("Ollama")
                .model(properties.getModel())
                .build();
    }
}
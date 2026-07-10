package com.AIClient.AiClient.Provider;

import com.AIClient.AiClient.AiResponse;
import com.AIClient.AiClient.Config.GeminiConfig.GeminiProperties;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

import java.security.ProviderException;

@Service
public class GeminiAiProvider implements AiProvider {

    private final GeminiProperties properties;
    private final Client client;

    public GeminiAiProvider(GeminiProperties properties) {
        this.properties = properties;

        this.client = Client.builder()
                .apiKey(properties.getApiKey())
                .build();
    }

    @Override
    public AiResponse response(String prompt) {

        try {
            GenerateContentResponse response =
                    client.models.generateContent(
                            properties.getModel(),
                            prompt,
                            null
                    );

            String text = response.text();

            if (text == null || text.isBlank()) {
                throw new ProviderException("Gemini returned an empty response.");
            }

            return AiResponse.builder()
                    .response(text)
                    .provider("Gemini")
                    .model(properties.getModel())
                    .build();

        } catch (Exception e) {
            throw new ProviderException("Gemini request failed.", e);
        }
    }
}
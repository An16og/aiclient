package com.AIClient.AiClient.Client;

import com.AIClient.AiClient.AiResponse;
import com.AIClient.AiClient.Provider.AiProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiClient {

    private final List<AiProvider> providers;

    public AiClient(List<AiProvider> providers) {
        this.providers = providers;
    }

    public AiResponse chat(String prompt) {

        Exception lastException = null;

        for (AiProvider provider : providers) {

            try {

                System.out.println("Trying provider: "
                        + provider.getClass().getSimpleName());

                return provider.response(prompt);

            } catch (Exception e) {

                lastException = e;

                System.out.println("Provider failed: "
                        + provider.getClass().getSimpleName());

            }
        }

        throw new RuntimeException(
                "All AI providers failed.",
                lastException
        );
    }
}
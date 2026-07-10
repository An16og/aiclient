package com.AIClient.AiClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiClientApplication.class, args);
	}

}

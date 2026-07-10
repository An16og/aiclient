# AIClient
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

A lightweight Spring Boot library that provides a unified interface for interacting with multiple Large Language Model (LLM) providers.

Instead of rewriting your application every time you switch AI providers, AIClient lets you interact with them through a common interface.

---


## Features

- Unified provider interface
- Spring Boot integration
- Provider-based architecture
- Common response DTO
- Automatic provider fallback (coming soon)

---

## Supported Providers

| Provider | Status |
|----------|--------|
| Google Gemini | ✅ Supported |
| Ollama | 🚧 In Progress |
| OpenAI | 📌 Planned |
| Anthropic Claude | 📌 Planned |
| Groq | 📌 Planned |

---

## Architecture

```
Application
      │
      ▼
 AIClient
      │
      ▼
 Provider Interface
 ├── GeminiProvider
 ├── OllamaProvider
 ├── OpenAIProvider
 └── ...
```

Each provider implements the same interface, allowing applications to switch providers with minimal code changes.

---

## Example

```java
AiResponse response = aiClient.chat("Explain dependency injection.");

System.out.println(response.getResponse());
```

---

## Configuration

```properties
ai.gemini.api-key=YOUR_API_KEY
ai.gemini.model=gemini-2.5-flash
```

---

## Tech Stack

- Java 17
- Spring Boot 3
- Google GenAI SDK
- Maven

---

## Roadmap

### v0.2

- OpenAI Provider
- Ollama Provider
- Better exception handling

### v0.3

- Automatic provider fallback
- Retry mechanism
- Health checks

### v0.4

- Streaming responses
- Async execution
- Conversation support

### v1.0

- Spring Boot Starter
- Maven Central publishing
- Complete provider ecosystem

---

## Project Status

Early development.

The API is expected to evolve as more providers and features are added.

---

## License

MIT

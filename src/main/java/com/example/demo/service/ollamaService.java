package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

    @Service
    public class ollamaService {

        private final WebClient webClient;

        public ollamaService(WebClient.Builder webClientBuilder) {
            this.webClient = webClientBuilder.baseUrl("http://localhost:11434").build();
        }

        public Mono<String> askDeepSeek(String prompt) {
            return webClient.put()
                    .uri("/api/generate")
                    .bodyValue(Map.of("model", " deepseek-r1:1.5b", "prompt", prompt))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .map(response -> response.get("response").toString());
        }
    }



package com.example.demo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
    @Service
    public class ollamaService {

        private static final String OLLAMA_URL = "http://localhost:11434/api/generate"; // Ollama API URL

        private final RestTemplate restTemplate;

        public ollamaService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public String sendMessageToDeepSeek(String message) {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "deepseek-r1:1.5b"); // Ensure DeepSeek is installed in Ollama
            requestBody.put("prompt", message);
            requestBody.put("stream", false);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.exchange(OLLAMA_URL, HttpMethod.POST, requestEntity, Map.class);

            Map<String, Object> responseBody = response.getBody();
            return responseBody != null ? responseBody.get("response").toString() : "No response";
        }
    }



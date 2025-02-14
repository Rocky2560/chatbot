package com.example.demo.controller;

import com.example.demo.service.ollamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

    @Controller
    public class ollamaController {

        private final ollamaService ollamaService;


        public ollamaController(com.example.demo.service.ollamaService ollamaService) {
            this.ollamaService = ollamaService;
        }

        @GetMapping
        public String showChatPage() {
            return "chat"; // This maps to "chat.html" in resources/templates/
        }

        @PostMapping("/chat")
        public String chatWithDeepSeek(@RequestParam String message, Model model) {
            String response = ollamaService.sendMessageToDeepSeek(message);
            model.addAttribute("userMessage", message);
            model.addAttribute("botResponse", response);
            return "chat";
        }

    }


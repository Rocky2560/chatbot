package com.example.demo.controller;

import com.example.demo.service.ollamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

    @Controller
    public class ollamaController {

        private final ollamaService ollamaService;

        public ollamaController(ollamaService ollamaService) {
            this.ollamaService = ollamaService;
        }

        @GetMapping ("/test")
        public String index()
        {
            return "index";
        }

        @GetMapping("/query")
        public String getResponse(@RequestParam String prompt, Model model) {
            String response = ollamaService.askDeepSeek(prompt).block(); // Blocking call for simplicity
            model.addAttribute("response", response);
            System.out.println("hello");
//            return ollamaService.askDeepSeek(prompt);
            return "responsePage";
        }

    }


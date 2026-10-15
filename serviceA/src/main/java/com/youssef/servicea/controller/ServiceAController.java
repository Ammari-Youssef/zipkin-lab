package com.youssef.servicea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class ServiceAController {

    private final WebClient webClient = WebClient.create("http://serviceB:8082");

    @GetMapping("/api/a")
    public Mono<Map<String, Object>> callServiceB() {
        return webClient.get()
                .uri("/api/b")
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> Map.of(
                        "service", "A",
                        "calledService", response
                ));
    }
}
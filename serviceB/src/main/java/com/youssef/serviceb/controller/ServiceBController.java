package com.youssef.serviceb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ServiceBController {

    @GetMapping("/api/b")
    public Map<String, String> serviceB() {
        return Map.of("service", "B", "status", "ok");
    }
}
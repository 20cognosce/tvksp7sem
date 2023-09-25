package com.mirea.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class HealthController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<String> getHealthStatus() {
        return ResponseEntity.ok("OK");
    }
}

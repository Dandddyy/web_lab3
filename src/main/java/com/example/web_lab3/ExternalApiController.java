package com.example.web_lab3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @GetMapping
    public ResponseEntity<String> getExternalApiResponse() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.getForObject("https://uselessfacts.jsph.pl/api/v2/facts/random?language=en", String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Failed to access");
        }
    }
}
package com.drn.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class TestController {
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return ResponseEntity.ok("Database connection is successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Database connection failed");
        }
    }
}

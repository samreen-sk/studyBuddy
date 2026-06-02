package com.example.studyBuddy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {

    private final JdbcTemplate jdbcTemplate;

    @Bean
    public ApplicationRunner noteContentColumnUpdater() {
        return args -> jdbcTemplate.execute(
                "ALTER TABLE IF EXISTS note ALTER COLUMN content TYPE TEXT"
        );
    }
}

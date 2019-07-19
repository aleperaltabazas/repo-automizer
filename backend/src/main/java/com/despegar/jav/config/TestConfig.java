package com.despegar.jav.config;

import com.despegar.jav.service.MockCreationService;
import com.despegar.jav.service.RepoCreationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.despegar.jav")
public class TestConfig {
    @Bean
    public RepoCreationService repoCreationService() {
        return new MockCreationService();
    }
}
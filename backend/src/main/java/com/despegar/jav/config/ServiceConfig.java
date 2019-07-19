package com.despegar.jav.config;

import com.despegar.jav.service.GithubService;
import com.despegar.jav.service.RepoCreationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.despegar.jav")
public class ServiceConfig {
    @Bean
    public RepoCreationService repoCreationService() {
        return new GithubService();
    }
}
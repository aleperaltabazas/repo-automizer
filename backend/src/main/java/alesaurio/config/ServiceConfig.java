package alesaurio.config;

import alesaurio.service.GithubService;
import alesaurio.service.RepoCreationService;
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
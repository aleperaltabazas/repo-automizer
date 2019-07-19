package alesaurio.config;

import alesaurio.service.MockCreationService;
import alesaurio.service.RepoCreationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.despegar.jav")
public class TestConfig {
    @Bean
    public RepoCreationService repoCreationService() {
        return new MockCreationService();
    }
}
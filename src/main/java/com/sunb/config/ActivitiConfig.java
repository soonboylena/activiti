package com.sunb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunb on 17-4-15.
 */
@Configuration
public class ActivitiConfig {

    @Bean
    public ProcessEngine configuration() {
        return ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration().buildProcessEngine();
    }
}

package com.sunb.config;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created by sunb on 17-4-15.
 */
public class ActivitiConfig {

    @Bean
    public ProcessEngineConfiguration configuration() {
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDatabaseType("mysql");
        return configuration;
    }
}

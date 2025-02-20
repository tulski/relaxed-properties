package com.tulski.relaxedproperties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(RelaxedPropertiesApplication.AppConfig.class)
public class RelaxedPropertiesApplication {

    private static final Logger log = LoggerFactory.getLogger(RelaxedPropertiesApplication.class);

    public static void main(String[] args) {
        final var context = SpringApplication.run(RelaxedPropertiesApplication.class, args);
        final var appConfig = context.getBean(AppConfig.class);
        log.info("Output config:\n{}", appConfig);
    }

    @ConfigurationProperties(prefix = "app-config")
    record AppConfig(Map<String, String> tenantTimezone) {
    }
}



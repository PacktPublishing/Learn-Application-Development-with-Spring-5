package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GreeterConfiguration {

    @Autowired
    private DatabaseConfiguration databaseConfig;

    @Bean
    @Scope(value = "prototype")
    public Greeter greeter() {
        return new Greeter();
    }

    @Bean
    public FriendlyGreeter friendlyGreeter() {
        return new FriendlyGreeter(databaseConfig);
    }
}

package com.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FriendlyGreeter extends GreeterBase implements InitializingBean, DisposableBean {

    private DatabaseConfiguration config;

    FriendlyGreeter(DatabaseConfiguration config) {
        this.config = config;
    }

    @Override
    public String greet() {
        greetCount++;
        return "Friendly Greeting " + greetCount + " " + config.getUrl() + " " + config.getUsername();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("preDestroy");
    }
}

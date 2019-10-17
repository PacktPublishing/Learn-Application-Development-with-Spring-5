package com.demo;

public class Greeter extends GreeterBase {

    @Override
    public String greet() {
        greetCount++;
        return "Hello " + greetCount;
    }
}

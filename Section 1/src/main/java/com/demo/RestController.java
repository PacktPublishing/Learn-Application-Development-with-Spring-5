package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }
}

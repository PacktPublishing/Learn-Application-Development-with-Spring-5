package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private Greeter greeter;

    @Autowired
    private FriendlyGreeter friendlyGreeter;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return greeter.greet();
    }

    @RequestMapping(value = "/hellofriendly", method = RequestMethod.GET)
    public String helloFriendly() {
        return friendlyGreeter.greet();
    }
}

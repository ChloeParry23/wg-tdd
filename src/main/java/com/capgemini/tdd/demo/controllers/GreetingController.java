package com.capgemini.tdd.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.capgemini.tdd.demo.models.Greeting;

import com.capgemini.tdd.demo.models.TalkyNumber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/talkynumbers")
    public TalkyNumber talkynumbers(@RequestParam(value = "number", defaultValue = "1") String number) {
        return new TalkyNumber(counter.incrementAndGet(),
                Integer.parseInt(number));
    }
}


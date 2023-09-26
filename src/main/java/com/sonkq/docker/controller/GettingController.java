package com.sonkq.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GettingController {
    @GetMapping("/greating")
    public String Greating() {
        return "Hello World!";
    }
}

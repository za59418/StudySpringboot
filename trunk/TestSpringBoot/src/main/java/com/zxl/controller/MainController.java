package com.zxl.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/login")
    String login() {
        return "login";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}

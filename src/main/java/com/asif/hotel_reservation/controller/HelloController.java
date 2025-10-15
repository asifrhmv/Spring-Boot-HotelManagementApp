package com.asif.hotel_reservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint(){
        return "Bu endpoint aciqdir!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello, secure hotel world!";
    }
}

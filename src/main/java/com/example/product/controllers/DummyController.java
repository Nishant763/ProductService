package com.example.product.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/callUserService")
public class DummyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){

        String answer = restTemplate.getForObject("http://192.168.1.15:8082/hi",String.class);

        return answer;
    }

    

}

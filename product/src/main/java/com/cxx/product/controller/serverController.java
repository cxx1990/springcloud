package com.cxx.product.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class serverController {


    @GetMapping("/msg")
    public String msg() {
        return "this is product msg1!";
    }

}


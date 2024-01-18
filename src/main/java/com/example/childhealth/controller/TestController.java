package com.example.childhealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("test")
    public String test(){
        return "Test";
    }

    @GetMapping("/")
    public String showIndex(){
        return "redirect:parentProfiles";
    }
}

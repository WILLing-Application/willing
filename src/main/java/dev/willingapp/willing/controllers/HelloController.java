package dev.willingapp.willing.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/home")
    public String hello() {
        return "home";
    }
}

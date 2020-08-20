package dev.willingapp.willing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String returnTestPage() {
        return "testing/test-images";
    }
}

package dev.willingapp.willing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevProfileController {
    @GetMapping("/devs")
//    @ResponseBody
    public String returnLandingMessage() {
        //return home.html
        return "dev-profile";
    }
}
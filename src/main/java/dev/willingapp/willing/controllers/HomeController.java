package dev.willingapp.willing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//connected to ProfileController.java, landingpage.html
@Controller
public class HomeController {
    @GetMapping("/")
//    @ResponseBody
    public String returnLandingMessage(){
        //return home.html
        return "home";
    }
}

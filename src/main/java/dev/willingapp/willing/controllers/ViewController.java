package dev.willingapp.willing.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    public ViewController(){}

    @GetMapping("/view")
    public String showView(Model model) {return "view";}



}
